// MainProgram.java
import StudentRecords.Student;

public class studentdetail {
    public static void main(String[] args) {
        // Create Student objects
        Student student1 = new Student(101, "Alice Smith", "A");
        Student student2 = new Student(102, "Bob Johnson", "B");

        // Display student information
        student1.displayStudentInfo();
        System.out.println(); // Add a line break
        student2.displayStudentInfo();
    }
}

