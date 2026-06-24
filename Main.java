import java.util.*;

// Course class to represent a course
class Course {
    private String courseId;
    private String courseName;
    private String description;
    private String instructorName;

    // Constructor
    public Course(String courseId, String courseName, String description, String instructorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.instructorName = instructorName;
    }

    // Getter methods
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructorName() {
        return instructorName;
    }
}

// Assignment class to represent an assignment
class Assignment {
    private String assignmentId;
    private String courseId;
    private String studentId;
    private String submission;

    // Constructor
    public Assignment(String assignmentId, String courseId, String studentId, String submission) {
        this.assignmentId = assignmentId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.submission = submission;
    }

    // Getter methods
    public String getAssignmentId() {
        return assignmentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubmission() {
        return submission;
    }
}

// Main class representing the Online Course Management System
public class CourseManagementSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<String> enrolledStudents = new ArrayList<>();
    private static List<Assignment> assignments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to create a new course
    public static void createCourse() {
        System.out.println("Enter course details:");
        System.out.print("Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Instructor Name: ");
        String instructorName = scanner.nextLine();

        Course course = new Course(courseId, courseName, description, instructorName);
        courses.add(course);
        System.out.println("Course created successfully.");
    }

    // Method to enroll in a course
    public static void enrollInCourse() {
        System.out.println("Enter enrollment details:");
        System.out.print("Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        enrolledStudents.add(courseId + "-" + studentId);
        System.out.println("Enrollment confirmed, course access granted.");
    }

    // Method to submit an assignment
    public static void submitAssignment() {
        System.out.println("Enter assignment details:");
        System.out.print("Assignment ID: ");
        String assignmentId = scanner.nextLine();
        System.out.print("Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Submission: ");
        String submission = scanner.nextLine();

        Assignment assignment = new Assignment(assignmentId, courseId, studentId, submission);
        assignments.add(assignment);
        System.out.println("Assignment submitted, feedback provided.");
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nOnline Course Management System Menu:");
            System.out.println("1. Create a course");
            System.out.println("2. Enroll in a course");
            System.out.println("3. Submit an assignment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    enrollInCourse();
                    break;
                case 3:
                    submitAssignment();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
        
        scanner.close(); // Close scanner when done
    }
}
