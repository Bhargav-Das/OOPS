import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        
        scanner.close();
        
        try (FileWriter writer = new FileWriter("student.txt", true)) {
            writer.write("Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + "\n");
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
