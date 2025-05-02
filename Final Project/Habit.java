public class Habit {
    public int habitId;       // Public field for habit ID
    public int userId;        // Public field for user ID
    public String habitName;   // Public field for habit name
    public boolean isCompleted; // Track if the habit is completed
    public int points; 

    // Constructor
    public Habit(int habitId, int userId, String habitName, boolean isCompleted) {
        this.habitId = habitId;
        this.userId = userId;
        this.habitName = habitName;
        this.points = 0; // Initialize points
        this.isCompleted = isCompleted; // Initialize as not completed
    }

    public void complete() {
        this.isCompleted = true;
    }
}