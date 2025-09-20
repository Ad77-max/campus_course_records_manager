package edu.ccrm.domain;

import java.time.LocalDate;

/**
 * Represents the link between a Student and a Course.
 */
public class Enrollment {
    private final String studentId;
    private final String courseCode;
    private final LocalDate enrollmentDate;
    private Grade grade;

    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.enrollmentDate = LocalDate.now();
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}
