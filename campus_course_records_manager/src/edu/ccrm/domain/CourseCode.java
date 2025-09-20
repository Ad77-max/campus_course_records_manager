package edu.ccrm.domain;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Immutable value object representing a course code
 * Demonstrates immutability with final fields and validation
 */
public final class CourseCode {
    
    // Final fields make this class immutable
    private final String department;
    private final String number;
    private final String fullCode;
    
    // Pattern for course code validation (e.g., CS101, MATH201)
    private static final Pattern COURSE_CODE_PATTERN = 
            Pattern.compile("^([A-Z]{2,4})(\\d{3,4})$");
    
    /**
     * Constructor with validation
     * @param courseCode Full course code (e.g., "CS101", "MATH201")
     * @throws IllegalArgumentException if invalid format
     */
    public CourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        
        String code = courseCode.trim().toUpperCase();
        var matcher = COURSE_CODE_PATTERN.matcher(code);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                "Invalid course code format. Expected format: [DEPT][NUMBER] (e.g., CS101)");
        }
        
        this.department = matcher.group(1);
        this.number = matcher.group(2);
        this.fullCode = code;
    }
    
    /**
     * Constructor with separate department and number
     * @param department Department code (e.g., "CS", "MATH")
     * @param number Course number (e.g., "101", "201")
     */
    public CourseCode(String department, String number) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException("Course number cannot be null or empty");
        }
        
        this.department = department.trim().toUpperCase();
        this.number = number.trim();
        this.fullCode = this.department + this.number;
        
        // Validate the combined code
        if (!COURSE_CODE_PATTERN.matcher(this.fullCode).matches()) {
            throw new IllegalArgumentException(
                "Invalid course code components: " + this.fullCode);
        }
    }
    
    // Only getters, no setters (immutable)
    public String getDepartment() {
        return department;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getFullCode() {
        return fullCode;
    }
    
    /**
     * Get course level based on first digit of course number
     * @return Course level (1=Freshman, 2=Sophomore, etc.)
     */
    public int getLevel() {
        return Character.getNumericValue(number.charAt(0));
    }
    
    /**
     * Check if this is an advanced course (300+ level)
     * @return true if course number starts with 3 or higher
     */
    public boolean isAdvancedCourse() {
        return getLevel() >= 3;
    }
    
    /**
     * Static factory method for parsing course codes
     * @param courseCode String representation of course code
     * @return CourseCode instance
     */
    public static CourseCode parse(String courseCode) {
        return new CourseCode(courseCode);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CourseCode that = (CourseCode) obj;
        return Objects.equals(fullCode, that.fullCode);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fullCode);
    }
    
    @Override
    public String toString() {
        return fullCode;
    }
}
