import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
    private static final String DB_USER = "root"; // Change if needed
    private static final String DB_PASS = "P1SSWOR4@1234"; // Change if needed

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement()) {

            // Step 1: Create database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS habit_tracker");
            stmt.executeUpdate("USE habit_tracker");

            // Step 2: Create users table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(50) NOT NULL UNIQUE,
                    password VARCHAR(255) NOT NULL,
                    points INT DEFAULT 0,
                    coins INT DEFAULT 0,
                    streak INT DEFAULT 0
                )
            """);

            // Step 3: Create habits table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS habits (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    user_id INT,
                    name VARCHAR(100) NOT NULL,
                    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
                    is_completed BOOLEAN DEFAULT FALSE,
                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
                )
            """);

            // Step 4: Create completed_habits table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS completed_habits (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    user_id INT,
                    habit_id INT,
                    completion_date DATE NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                    FOREIGN KEY (habit_id) REFERENCES habits(id) ON DELETE CASCADE,
                    UNIQUE(user_id, habit_id, completion_date)
                )
            """);

            System.out.println("✅ Database and tables created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}