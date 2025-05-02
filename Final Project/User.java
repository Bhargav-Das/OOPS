public class User {
    public int userId;        // Public field for user ID
    public String username;    // Public field for username
    public String password;    // Public field for password
    public int points;         // Points earned by the user
    public int coins;          // Coins earned by the user

    // Constructor
    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.points = 0; // Initialize points
        this.coins = 0;  // Initialize coins
    }

    public void addPoints(int points) {
        this.points += points;
        this.coins += points * 2; // 1 point = 2 coins
    }
}