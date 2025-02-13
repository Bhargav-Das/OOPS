// StudentRecords/Student.java
package StudentRecords;

public class Student {
    private int studentId;
    private String name;
    private String grade;

    // Public constructor to initialize attributes
    public Student(int studentId, String name, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    // Public method to display student information
    public void displayStudentInfo() {
        System.out.println("Student Details:");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

