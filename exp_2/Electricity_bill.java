import java.util.Scanner;

public class Electricity_bill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total units consumed: ");
        int units = scanner.nextInt();
        double bill = calculateBill(units);
        System.out.println("The total electricity bill is: Rs " + bill);
        scanner.close();
    }

    public static double calculateBill(int units) {
        double bill = 0;
        if (units <= 100) {
            bill = units * 5;
        } else if (units <= 200) {
            bill = 100 * 5 + (units - 100) * 7;
        } else if (units <= 300) {
            bill = 100 * 5 + 100 * 7 + (units - 200) * 10;
        } else {
            bill = 100 * 5 + 100 * 7 + 100 * 10 + (units - 300) * 15;
        }
        return bill;
    }
}
