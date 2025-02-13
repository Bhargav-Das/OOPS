// BankingSystem/BankAccount.java
package BankingSystem;

public class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Public method for deposit
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Protected method for withdrawal (authorized transactions)
    protected void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Default-access method for checking balance (within the same package)
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }

    // Private method for calculating interest
    private double calculateInterest() {
        // Simplified interest calculation for demonstration
        return balance * 0.05;
    }
}

