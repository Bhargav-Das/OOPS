import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TrackerGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private List<Habit> habits; // List to store habits

    public TrackerGUI() {
        habits = new ArrayList<>(); // Initialize the habit list
        loadHabits(); // Load habits from file

        frame = new JFrame("Habit Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Username Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        frame.add(usernameField);

        // Password Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        frame.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login logic
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // For demonstration, assume any non-empty username/password is valid
                if (!username.isEmpty() && !password.isEmpty()) {
                    showMainMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter valid credentials.");
                }
            }
        });

        frame.setVisible(true);
    }

    private void showMainMenu() {
        // Close the login frame
        frame.dispose();

        // Create a new frame for the main menu
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setSize(400, 300);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setLayout(null);

        // Add Habit Button
        JButton addHabitButton = new JButton("Add Habit");
        addHabitButton.setBounds(50, 50, 300, 30);
        mainMenuFrame.add(addHabitButton);

        addHabitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddHabitGUI(habits); // Pass the habit list to the Add Habit GUI
            }
        });

        // View Habits Button
        JButton viewHabitsButton = new JButton("View Habits");
        viewHabitsButton.setBounds(50, 100, 300, 30);
        mainMenuFrame.add(viewHabitsButton);

        viewHabitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHabits(); // Show the list of habits
            }
        });

        // Complete Habit Button
        JButton completeHabitButton = new JButton("Complete Habit");
        completeHabitButton.setBounds(50, 150, 300, 30);
        mainMenuFrame.add(completeHabitButton);

        completeHabitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                completeHabit(); // Call the method to complete a habit
            }
        });

        // View Points and Coins Button
        JButton viewPointsButton = new JButton("View Points and Coins");
        viewPointsButton.setBounds(50, 200, 300, 30);
        mainMenuFrame.add(viewPointsButton);

        viewPointsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPointsAndCoins(); // Call the method to view points and coins
            }
        });

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(50, 250, 300, 30);
        mainMenuFrame.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHabits(); // Save habits to file before exiting
                System.exit(0); // Exit the application
            }
        });

        mainMenuFrame.setVisible(true);
    }

    private void viewPointsAndCoins() {
        int totalPoints = 0;
        for (Habit habit : habits) {
            totalPoints += habit.points; // Sum up points from all habits
        }
        int totalCoins = totalPoints * 2; // Calculate total coins (2 coins per point)
        JOptionPane.showMessageDialog(null, "Total Points: " + totalPoints + "\nTotal Coins: " + totalCoins);
    }

    private void completeHabit() {
        String habitName = JOptionPane.showInputDialog("Enter the name of the habit to complete:");
        if (habitName != null && !habitName.isEmpty()) {
            for (Habit habit : habits) {
                if (habit.habitName.equalsIgnoreCase(habitName) && !habit.isCompleted) {
                    habit.isCompleted = true; // Mark the habit as completed
                    habit.points += 1; // Award 1 point
                    int coins = habit.points * 2; // Calculate coins
                    JOptionPane.showMessageDialog(null, "Habit completed! You earned 1 point and " + coins + " coins.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Habit not found or already completed.");
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid habit name.");
        }
    }

    private void showHabits() {
        if (habits.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No habits added yet.");
        } else {
            StringBuilder habitList = new StringBuilder("Your Habits:\n");
            for (Habit habit : habits) {
                habitList.append(habit.habitName)
                          .append(habit.isCompleted ? " (Completed)" : "")
                          .append("\n");
            }
            JOptionPane.showMessageDialog(null, habitList.toString(), "Your Habits", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void loadHabits() {
        // Load habits from file (implementation as discussed previously)
    }

    private void saveHabits() {
        // Save habits to file (implementation as discussed previously)
    }

    public static void main(String[] args) {
        new TrackerGUI();
    }
}