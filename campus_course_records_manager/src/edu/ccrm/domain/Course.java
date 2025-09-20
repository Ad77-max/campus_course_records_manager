package edu.ccrm.domain;

/**
 * Represents a course.
 * This class uses the Builder Pattern for object creation.
 */
public class Course {
    private final String code;
    private final String title;
    private final int credits;
    private String instructorId;
    private final Semester semester;
    private final String department;

    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructorId = builder.instructorId;
        this.semester = builder.semester;
        this.department = builder.department;
    }

    // Getters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getInstructorId() { return instructorId; }
    public Semester getSemester() { return semester; }
    public String getDepartment() { return department; }
    public void setInstructorId(String instructorId) { this.instructorId = instructorId; }

    // Static nested Builder class
    public static class Builder {
        private final String code;
        private final String title;
        private int credits = 3; // Default value
        private String instructorId;
        private Semester semester = Semester.FALL; // Default
        private String department;

        public Builder(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public Builder credits(int credits) {
            this.credits = credits;
            return this;
        }

        public Builder instructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }
        
        public Builder semester(Semester semester) {
            this.semester = semester;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}