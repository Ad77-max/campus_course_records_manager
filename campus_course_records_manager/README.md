Campus Course & Records Manager (CCRM)
A complete Java SE application for managing enrollments, courses, students, and academic records of an educational institute.
Table of Contents

:Project Overview
:How to Run
:Java Evolution Timeline
:Java Platform Comparison
:JDK/JRE/JVM Architecture
:Installation Guide
:Technical Requirements Mapping
:Features
:Project Structure
:Usage Examples
:Assertions
:Acknowledgments

Project Overview
CCRM is a Java console application that illustrates thorough Java programming principles such as OOP concepts, design patterns, exception handling, file I/O, and new Java features like Streams API and Date/Time API.
Key Features

:Student Management: Add, update, search, and manage student records
:Course Management: Create and manage course offerings with prerequisites
:Enrollment System: Manage student course enrollments with business rule validation
:Grade Management: Store grades and calculate GPA
:File Operations: Import/export data and backup functionality
:Reporting: Generate various academic reports and analytics

How to Run
Prerequisites

:JDK 8 or later (recommended: JDK 11+)
:Command line or IDE (Eclipse recommended)

Running from Command Line
bash# Compile the project
javac -cp src -d bin src/edu/ccrm/*.java src/edu/ccrm/*/*.java

# Run with assertions enabled
java -ea -cp bin edu.ccrm.CCRMApplication

# Run normally
java -cp bin edu.ccrm.CCRMApplication
Running from Eclipse IDE

Import project into Eclipse workspace
Right-click on CCRMApplication.java
Select "Run As" → "Java Application"
To enable assertions: Run → Run Configurations → Arguments → VM Arguments: -ea

Java Evolution Timeline
Major Java Releases

1995: Java 1.0 - First release with core language features
1997: Java 1.1 - Inner classes, JavaBeans, JDBC, RMI
1998: Java 1.2 (J2SE) - Collections Framework, Swing, JIT compiler
2000: Java 1.3 - HotSpot JVM, JNDI, JavaSound
2002: Java 1.4 - Assertions, regular expressions, NIO, XML processing
2004: Java 5.0 - Generics, autoboxing, enums, varargs, enhanced for loop
2006: Java 6 - Performance enhancements, scripting engine support
2011: Java 7 - Try-with-resources, diamond operator, multi-catch
2014: Java 8 - Lambda expressions, Stream API, Optional, Date/Time API
2017: Java 9 - Module system, JShell, private interface methods
2018: Java 10 - Local variable type inference (var)
2018: Java 11 - String methods, HTTP client, eliminated JavaFX
2019: Java 12 - Switch expressions (preview)
2019: Java 13 - Text blocks (preview)
2020: Java 14 - Switch expressions (standard), pattern matching (preview)
2020: Java 15 - Text blocks (standard), sealed classes (preview)
2021: Java 17 (LTS) - Pattern matching for instanceof, sealed classes
2022: Java 18 - UTF-8 by default, simple web server
2022: Java 19 - Virtual threads (preview), pattern matching (preview)
2023: Java 20 - Scoped values (preview), structured concurrency (preview)
2023: Java 21 (LTS) - Virtual threads, pattern matching for switch

Java Platform Comparison
PlatformDescriptionUse CasesKey FeaturesJava ME (Micro Edition)For mobile and embedded devicesIoT devices, mobile phones, embedded systemsMinimal footprint, CDC/CLDC configurationsJava SE (Standard Edition)Core Java platform for desktop/serverDesktop applications, command-line tools, server applicationsComplete Java API, JVM, development toolsJava EE (Enterprise Edition)Enterprise application developmentWeb applications, enterprise services, distributed systemsServlets, JSP, EJB, JMS, web services
Current Project Platform
This CCRM project employs Java SE because it is a desktop-based application that does not need enterprise functionality or mobile limitations.
JDK/JRE/JVM Architecture
Components Overview
┌─────────────────────────────────────┐
│           JDK (Development Kit)      │
│  ┌─────────────────────────────────┐ │
│  │         JRE (Runtime)           │ │
│  │  ┌─────────────────────────────┐│ │
│  │  │       JVM (Virtual Machine) ││ │
│  │  │  - Bytecode execution       ││ │
│  │  │  - Memory management        ││ │
│  │  - Garbage collection       ││ │
│  │  └─────────────────────────────┘│ │
│  │  - Java API Libraries            │ │
│  │  - Core classes (java.*, javax.*)│ │
│  └─────────────────────────────────┘ │
│  - Compiler (javac)                  │
│  - Debugger (jdb)                    │
│  - Documentation (javadoc)           │
└─────────────────────────────────────┘
Component Interactions

JDK (Java Development Kit)

Full development environment
Includes JRE + development tools
Employed in compiling and building Java applications

JRE (Java Runtime Environment)

Runtime environment for running Java applications
Includes JVM + core libraries
End users require only JRE to run Java applications

JVM (Java Virtual Machine)

Runs Java bytecode
Gives platform independence
Manages memory and system resources

Installation Guide
Windows Installation Steps
Step 1: Download JDK

Go to Oracle JDK or OpenJDK
Download JDK 11 or newer for Windows x64
Run the installer (.exe file)

Step 2: Set Environment Variables

Open System Properties → Advanced → Environment Variables
Add JAVA_HOME: Set to JDK installation directory

   JAVA_HOME = C:\\Program Files\\Java\\jdk-11.0.x

Update PATH: Append %JAVA_HOME%\\bin
Click OK to save changes

Step 3: Confirm Installation
Open Command Prompt and execute:
cmdjava -version
javac -version
Expected Output:
java version "11.0.x" 2023-xx-xx LTS
Java(TM) SE Runtime Environment (build 11.0.x+xx-LTS)
Java HotSpot(TM) 64-Bit Server VM (build 11.0.x+xx-LTS, mixed mode)
Eclipse IDE Setup
Step 1: Install Eclipse

Go to Eclipse IDE Downloads
Download "Eclipse IDE for Java Developers"
Extract and execute eclipse.exe

Step 2: Create New Java Project

File → New → Java Project
Project name: campus-course-records-manager
Use default location or provide custom path
Select JRE version (11 or higher recommended)
Click Finish

Step 3: Set Run Configuration

Right-click project → Run As → Run Configurations
Create new Java Application configuration
Main class: `edu.ccr
