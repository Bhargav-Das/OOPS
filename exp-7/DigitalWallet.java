public class DigitalWallet implements Wallet {
    private double balance;

    public DigitalWallet() {
        this.balance = 0.0;
    }

    @Override
    public void addFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Added " + amount + " to the wallet. Current balance: " + balance);
        } else {
            System.out.println("Amount to add should be positive.");
        }
    }

    @Override
    public void spendFunds(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Spent " + amount + " from the wallet. Current balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: " + balance);
        } else {
            System.out.println("Amount to spend should be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }
}