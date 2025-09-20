package edu.ccrm.domain;

/**
 * Custom exceptions for CCRM application
 * Demonstrates checked and unchecked exception handling
 */

/**
 * Checked exception for duplicate enrollment scenarios
 */
class DuplicateEnrollmentException extends Exception {
    private final String studentId;
    private final String courseCode;
    
    public DuplicateEnrollmentException(String studentId, String courseCode) {
        super(String.format("Student %s is already enrolled in course %s", studentId, courseCode));
        this.studentId = studentId;
        this.courseCode = courseCode;
    }
    
    public DuplicateEnrollmentException(String studentId, String courseCode, String message) {
        super(message);
        this.studentId = studentId;
        this.courseCode = courseCode;
    }
    
    public DuplicateEnrollmentException(String studentId, String courseCode, String message, Throwable cause) {
        super(message, cause);
        this.studentId = studentId;
        this.courseCode = courseCode;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
}

/**
 * Checked exception for credit limit scenarios
 */
class MaxCreditLimitExceededException extends Exception {
    private final String studentId;
    private final int currentCredits;
    private final int maxAllowedCredits;
    
    public MaxCreditLimitExceededException(String studentId, int currentCredits, int maxAllowedCredits) {
        super(String.format("Student %s cannot enroll. Current credits: %d, Max allowed: %d", 
                studentId, currentCredits, maxAllowedCredits));
        this.studentId = studentId;
        this.currentCredits = currentCredits;
        this.maxAllowedCredits = maxAllowedCredits;
    }
    
    public MaxCreditLimitExceededException(String studentId, int currentCredits, int maxAllowedCredits, String message) {
        super(message);
        this.studentId = studentId;
        this.currentCredits = currentCredits;
        this.maxAllowedCredits = maxAllowedCredits;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public int getCurrentCredits() {
        return currentCredits;
    }
    
    public int getMaxAllowedCredits() {
        return maxAllowedCredits;
    }
}

/**
 * Unchecked exception for invalid course operations
 */
class InvalidCourseOperationException extends RuntimeException {
    private final String courseCode;
    private final String operation;
    
    public InvalidCourseOperationException(String courseCode, String operation) {
        super(String.format("Invalid operation '%s' on course '%s'", operation, courseCode));
        this.courseCode = courseCode;
        this.operation = operation;
    }
    
    public InvalidCourseOperationException(String courseCode, String operation, String message) {
        super(message);
        this.courseCode = courseCode;
        this.operation = operation;
    }
    
    public InvalidCourseOperationException(String courseCode, String operation, String message, Throwable cause) {
        super(message, cause);
        this.courseCode = courseCode;
        this.operation = operation;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getOperation() {
        return operation;
    }
}

/**
 * Unchecked exception for student-related runtime errors
 */
class StudentOperationException extends RuntimeException {
    private final String studentId;
    private final String operation;
    
    public StudentOperationException(String studentId, String operation) {
        super(String.format("Student operation failed: %s for student %s", operation, studentId));
        this.studentId = studentId;
        this.operation = operation;
    }
    
    public StudentOperationException(String studentId, String operation, String message) {
        super(message);
        this.studentId = studentId;
        this.operation = operation;
    }
    
    public StudentOperationException(String studentId, String operation, Throwable cause) {
        super(String.format("Student operation failed: %s for student %s", operation, studentId), cause);
        this.studentId = studentId;
        this.operation = operation;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getOperation() {
        return operation;
    }
}

/**
 * Checked exception for prerequisite validation failures
 */
class PrerequisiteNotMetException extends Exception {
    private final String studentId;
    private final String courseCode;
    private final String missingPrerequisite;
    
    public PrerequisiteNotMetException(String studentId, String courseCode, String missingPrerequisite) {
        super(String.format("Student %s cannot enroll in %s. Missing prerequisite: %s", 
                studentId, courseCode, missingPrerequisite));
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.missingPrerequisite = missingPrerequisite;
    }
    
    public PrerequisiteNotMetException(String studentId, String courseCode, String missingPrerequisite, String message) {
        super(message);
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.missingPrerequisite = missingPrerequisite;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getMissingPrerequisite() {
        return missingPrerequisite;
    }
}

/**
 * Unchecked exception for data validation errors
 */
class DataValidationException extends RuntimeException {
    private final String field;
    private final String value;
    private final String validationRule;
    
    public DataValidationException(String field, String value, String validationRule) {
        super(String.format("Validation failed for field '%s' with value '%s'. Rule: %s", 
                field, value, validationRule));
        this.field = field;
        this.value = value;
        this.validationRule = validationRule;
    }
    
    public DataValidationException(String field, String value, String validationRule, String message) {
        super(message);
        this.field = field;
        this.value = value;
        this.validationRule = validationRule;
    }
    
    public String getField() {
        return field;
    }
    
    public String getValue() {
        return value;
    }
    
    public String getValidationRule() {
        return validationRule;
    }
}