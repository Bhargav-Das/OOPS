import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCharacterCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = input.nextLine();
        input.close();

        File file = new File(fileName);
        int wordCount = 0;
        int charCount = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordCount++;
                charCount += word.length();
            }
            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters (excluding spaces): " + charCount);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
