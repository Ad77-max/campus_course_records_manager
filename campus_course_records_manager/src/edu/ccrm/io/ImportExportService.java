package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.Student;
import edu.ccrm.service.StudentService;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImportExportService {
    private final Path studentsFile = AppConfig.getInstance().getDataDirectory().resolve("students.csv");

    public void exportStudents(StudentService studentService) throws IOException {
        Files.createDirectories(studentsFile.getParent());
        List<String> lines = studentService.getAllStudents().stream()
            .map(s -> String.join(",", s.getId(), s.getRegNo(), s.getFullName(), s.getEmail()))
            .collect(Collectors.toList());
        Files.write(studentsFile, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void importStudents(StudentService studentService) throws IOException {
        if (!Files.exists(studentsFile)) return;
        try (Stream<String> lines = Files.lines(studentsFile)) {
            List<Student> loadedStudents = lines
                .map(line -> {
                    String[] parts = line.split(",");
                    // Assumes CSV format: id,regNo,fullName,email
                    return new Student(parts[0], parts[1], parts[2], parts[3]);
                })
                .collect(Collectors.toList());
            studentService.replaceAll(loadedStudents);
            System.out.println("-> Imported " + loadedStudents.size() + " students from file.");
        }
    }
}
