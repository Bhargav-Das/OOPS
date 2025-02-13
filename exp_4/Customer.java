public class Customer {
    private double balance;

    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void addBalance(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    protected void deductBalance(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    void showBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.addBalance(100.50);
        customer.addBalance(50);
        customer.showBalance();
        customer.deductBalance(30);
        customer.showBalance();
    }
}
