package edu.ccrm.cli;

import edu.ccrm.domain.Grade;
import edu.ccrm.io.BackupService;
import edu.ccrm.io.ImportExportService;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.StudentServiceImpl;
import java.util.Scanner;

public class CCRMApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentServiceImpl();
    private static final ImportExportService importExportService = new ImportExportService();
    private static final BackupService backupService = new BackupService();

    public static void main(String[] args) {
        System.out.println("Welcome to Campus Course & Records Manager (CCRM)");
        loadInitialData();
        
        while (true) {
            printMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                handleMenuChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=========================================");
        System.out.println("  CCRM Main Menu");
        System.out.println("-----------------------------------------");
        System.out.println("  1. Add Student         2. List Students");
        System.out.println("  3. View Transcript     4. Assign Grade");
        System.out.println("  5. Export Data         6. Create Backup");
        System.out.println("  7. Platform Info       8. Exit");
        System.out.println("=========================================");
        System.out.print("Enter your choice: ");
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1: addStudent(); break;
            case 2: listStudents(); break;
            case 3: viewTranscript(); break;
            case 4: assignGrade(); break;
            case 5: exportData(); break;
            case 6: createBackup(); break;
            case 7: printPlatformInfo(); break;
            case 8: exitApplication(); break;
            default: System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void loadInitialData() {
        try {
            importExportService.importStudents(studentService);
        } catch (Exception e) {
            System.err.println("Could not load initial data: " + e.getMessage());
        }
    }
    
    private static void addStudent() {
        System.out.print("Enter RegNo: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        studentService.addStudent(regNo, name, email);
        System.out.println("Student added successfully!");
    }

    private static void listStudents() {
        System.out.println("\n--- List of All Students ---");
        studentService.getAllStudents().forEach(s -> System.out.println(s.getProfileDetails() + "\n"));
    }
    
    private static void viewTranscript() {
        System.out.print("Enter Student ID (e.g., STU101): ");
        String id = scanner.nextLine();
        studentService.findStudentById(id)
            .ifPresentOrElse(
                s -> System.out.println(s.generateTranscript()),
                () -> System.out.println("Student not found.")
            );
    }
    
    private static void assignGrade() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Grade (S, A, B, C, D, F): ");
        try {
            Grade grade = Grade.valueOf(scanner.nextLine().toUpperCase());
            if (studentService.assignGrade(studentId, courseCode, grade)) {
                System.out.println("Grade assigned.");
            } else {
                System.out.println("Failed. Student may not be enrolled or does not exist.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid grade. Please use S, A, B, C, D, or F.");
        }
    }

    private static void exportData() {
        try {
            importExportService.exportStudents(studentService);
        } catch (Exception e) {
            System.err.println("Export failed: " + e.getMessage());
        }
    }

    private static void createBackup() {
        try {
            backupService.createBackup();
        } catch (Exception e) {
            System.err.println("Backup failed: " + e.getMessage());
        }
    }

    private static void printPlatformInfo() {
        System.out.println("\n--- Java Platform Summary ---");
        System.out.println("Java SE (Standard Edition): For desktop and server applications. The core Java platform.");
        System.out.println("Java EE (Enterprise Edition): Extends SE with APIs for large-scale, multi-tiered, and web applications.");
        System.out.println("Java ME (Micro Edition): A subset of SE for resource-constrained devices like mobiles and embedded systems.");
    }

    private static void exitApplication() {
        System.out.println("Exporting data before shutdown...");
        exportData();
        System.out.println("Thank you for using CCRM. Goodbye!");
        System.exit(0);
    }
}
