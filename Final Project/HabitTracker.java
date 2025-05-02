import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitTracker {
    public User user; // Public field for the user
    private DatabaseManager dbManager; // Database manager for CRUD operations
    public List<Habit> habits; // Public list to store habits for the user

    public HabitTracker(User user) {
        this.user = user;
        this.dbManager = new DatabaseManager();
        this.habits = new ArrayList<>(); // Initialize the habit list
        loadHabits(); // Load habits from the database
    }

    // Load habits from the database
    private void loadHabits() {
        ResultSet rs = dbManager.getHabits(user.userId);
        try {
            while (rs != null && rs.next()) {
                Habit habit = new Habit(rs.getInt("id"), rs.getInt("user_id"), rs.getString("name"), rs.getBoolean("is_completed"));
                if (rs.getBoolean("is_completed")) {
                    habit.complete(); // Set completed status if applicable
                }
                habits.add(habit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new habit
    public void addHabit(String habitName) {
        Habit newHabit = new Habit(habits.size() + 1, user.userId, habitName, false);
        habits.add(newHabit);
        dbManager.addHabit(newHabit); // Add the habit to the database
    }

    // Method to complete a habit
    public void completeHabit(int habitId) {
        for (Habit habit : habits) {
            if (habit.habitId == habitId && !habit.isCompleted) {
                habit.complete(); // Mark the habit as completed
                user.addPoints(1); // Add 1 point for completing the habit
                System.out.println("Habit completed: " + habit.habitName);
                System.out.println("Points: " + user.points + ", Coins: " + user.coins);
                return;
            }
        }
        System.out.println("Habit not found or already completed.");
    }

    // Method to show user's habits
    public void showHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits found.");
            return;
        }

        System.out.println("Your Habits:");
        for (Habit habit : habits) {
            System.out.println(habit.habitName + (habit.isCompleted ? " (Completed)" : ""));
        }
    }
}