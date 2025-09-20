package edu.ccrm.domain;

/**
 * Abstract base class for Student and Instructor.
 * Manages common properties and defines a contract for subclasses.
 */
public abstract class Person {
    private String id;
    private String fullName;
    private String email;

    public Person(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }

    // --- Abstract Methods for Subclasses ---
    // This was missing, causing the "must implement" error in Student.java
    public abstract String getDisplayInfo();
    public abstract String getType();
    public abstract boolean isActive();
    
    // This was also missing a supertype to override
    public abstract String getProfileDetails();
}