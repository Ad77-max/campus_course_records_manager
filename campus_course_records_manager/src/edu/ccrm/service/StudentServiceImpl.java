package edu.ccrm.service;

import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentServiceImpl implements StudentService {
    private final Map<String, Student> students = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(100);

    @Override
    public Student addStudent(String regNo, String fullName, String email) {
        String id = "STU" + idCounter.incrementAndGet();
        Student student = new Student(id, regNo, fullName, email);
        students.put(id, student);
        return student;
    }

    @Override
    public Optional<Student> findStudentById(String id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public boolean assignGrade(String studentId, String courseCode, Grade grade) {
        return findStudentById(studentId).map(student -> {
            // In a real app, you'd check if the student is enrolled first.
            student.getCourseGrades().put(courseCode, grade);
            return true;
        }).orElse(false);
    }

    @Override
    public void replaceAll(List<Student> newStudents) {
        students.clear();
        newStudents.forEach(s -> students.put(s.getId(), s));
    }
}
