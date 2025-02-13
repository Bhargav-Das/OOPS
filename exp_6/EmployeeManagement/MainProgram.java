// MainProgram.java
import EmployeeManagement.Employee;

public class MainProgram {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("Alice Johnson", 12345, 50000.00);

        // Display employee details
        employee.displayDetails();
    }
}

