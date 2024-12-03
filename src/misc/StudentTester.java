package misc;

// Test cases
public class StudentTester {
    public static void main(String[] args) {
        // Test constructors
        Student s1 = new Student("John Smith", 12345);
        Student s2 = new Student("Jane Doe");  // Uses default constructor

        // Test getters/setters
        System.out.println("\n=== Testing Getters/Setters ===");
        System.out.println("Initial name: " + s1.getName());
        s1.setName("John A. Smith");
        System.out.println("Updated name: " + s1.getName());

        System.out.println("\nInitial id: " + s1.getId());
        s1.setId(54321);
        System.out.println("Updated id: " + s1.getId());
        System.out.println("Default id for s2: " + s2.getId());  // Should be -1

        // Test course management
        System.out.println("\n=== Testing Course Management ===");
        s1.addCourse(1, "AP Computer Science");
        s1.addCourse(2, "English Literature");
        s1.addCourse(3, "Physics");
        s1.addCourse(4, "US History");
        System.out.println("\nInitial schedule:");
        System.out.println(s1);

        // Test invalid period
        s1.addCourse(9, "Invalid Course");
        s1.addCourse(0, "Invalid Course");

        // Test dropping courses
        String dropped = s1.dropCourse(1);
        System.out.println("Dropped from period 1: " + dropped);
        dropped = s1.dropCourse(5);  // Empty period
        System.out.println("Dropped from empty period: " + dropped);  // Should be null

        // Test swapping courses
        System.out.println("\nBefore swap:");
        System.out.println(s1);

        boolean swapped = s1.swapCourses(2, 3);
        System.out.println("Swap successful (2 and 3): " + swapped);
        System.out.println("After swap:");
        System.out.println(s1);

        swapped = s1.swapCourses(1, 9);  // Invalid period
        System.out.println("Swap with invalid period: " + swapped);

        // Test second student
        System.out.println("\n=== Testing Second Student ===");
        s2.addCourse(1, "Calculus");
        s2.addCourse(2, "Spanish");
        s2.addCourse(3, "Chemistry");
        System.out.println(s2);

        s2.swapCourses(1, 3);
        System.out.println("\nAfter swapping periods 1 and 3:");
        System.out.println(s2);

        // Test toString with empty schedule
        Student s3 = new Student("Empty Schedule", 9999);
        System.out.println("\n=== Testing Empty Schedule ===");
        System.out.println(s3);
    }
}
