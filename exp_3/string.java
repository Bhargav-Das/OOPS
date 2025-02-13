import java.util.Arrays;
import java.util.Scanner;

public class string {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String s = scanner.nextLine();
        System.out.println("Enter the second string:");
        String t = scanner.nextLine();
        scanner.close();
        
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }
}
