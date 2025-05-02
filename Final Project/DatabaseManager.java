import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/habit_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "P1SSWOR4@1234";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to add a new user
    public void addUser (User user) {
        String sql = "INSERT INTO users (username, password, points, coins) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.username);
            stmt.setString(2, user.password);
            stmt.setInt(3, user.points);
            stmt.setInt(4, user.coins);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a user by username
    public User getUser (String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no user is found
    }

    // Method to add a new habit
    public void addHabit(Habit habit) {
        String sql = "INSERT INTO habits (user_id, name, is_completed) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, habit.userId);
            stmt.setString(2, habit.habitName);
            stmt.setBoolean(3, habit.isCompleted);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get habits for a user
    public ResultSet getHabits(int userId) {
        String sql = "SELECT * FROM habits WHERE user_id = ?";
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to log in a user
    public boolean loginUser (String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Return true if a matching user is found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no matching user is found
    }

    // Method to update user information
    public void updateUser (User user) {
        String sql = "UPDATE users SET password = ?, points = ?, coins = ? WHERE username = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.password);
            stmt.setInt(2, user.points);
            stmt.setInt(3, user.coins);
            stmt.setString(4, user.username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}