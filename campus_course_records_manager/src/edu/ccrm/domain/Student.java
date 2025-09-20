package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Student extends Person {
    public enum Status { ACTIVE, INACTIVE, GRADUATED }

    private final String regNo;
    private Status status;
    private final Map<String, Grade> courseGrades = new HashMap<>();

    public Student(String id, String regNo, String fullName, String email) {
        super(id, fullName, email);
        this.regNo = regNo;
        this.status = Status.ACTIVE;
    }

    // --- Getters ---
    public String getRegNo() { return regNo; }
    public Status getStatus() { return status; }
    public Map<String, Grade> getCourseGrades() { return courseGrades; }

    // --- Business Logic ---
    public double calculateGPA() {
        if (courseGrades.isEmpty()) return 0.0;
        double totalPoints = courseGrades.values().stream()
            .mapToDouble(Grade::getGradePoints)
            .sum();
        return totalPoints / courseGrades.size();
    }

    public String generateTranscript() {
        String grades = courseGrades.isEmpty() ? "  No grades recorded." : 
            courseGrades.entrySet().stream()
                .map(entry -> String.format("  - %-10s: %s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
        return String.format("--- TRANSCRIPT for %s ---%n%s%n--- Current GPA: %.2f ---", getFullName(), grades, calculateGPA());
    }

    // --- IMPLEMENTING ABSTRACT METHODS FROM PERSON ---
    @Override
    public String getDisplayInfo() {
        return String.format("RegNo: %s, Program: Computer Science, GPA: %.2f", regNo, calculateGPA());
    }

    @Override
    public String getType() {
        return "Student";
    }

    @Override
    public boolean isActive() {
        return status == Status.ACTIVE;
    }

    @Override
    public String getProfileDetails() {
        return String.format(
            "Student Profile:%n  ID: %s%n  RegNo: %s%n  Name: %s%n  Status: %s",
            getId(), getRegNo(), getFullName(), getStatus()
        );
    }
}