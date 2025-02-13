// UserAccount/Customer.java
package UserAccount;

import BankingSystem.BankAccount;

public class Customer {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);

        // Accessing public method
        account.deposit(500.00);

    }
}

