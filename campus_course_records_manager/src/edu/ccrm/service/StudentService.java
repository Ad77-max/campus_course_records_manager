package edu.ccrm.service;

import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    // All methods called by CCRMApplication must be defined here
    Student addStudent(String regNo, String fullName, String email);
    Optional<Student> findStudentById(String id);
    List<Student> getAllStudents();
    boolean assignGrade(String studentId, String courseCode, Grade grade);

    // Method needed by ImportExportService
    void replaceAll(List<Student> students);
}