public class FinalBalance {
    public static void main(String[] args) {
        DigitalWallet myWallet = new DigitalWallet();

        myWallet.addFunds(100.0);
        myWallet.spendFunds(30.0);
        myWallet.addFunds(50.0);
        myWallet.spendFunds(150.0);
        myWallet.spendFunds(20.0);

        // Attempt to access balance directly (should not be possible)
        // myWallet.balance = 1000.0; // This line would cause a compilation error

        System.out.println("Final balance: " + myWallet.getBalance());
    }
}
