import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddHabitGUI {
    private JFrame frame;
    private JTextField habitNameField;
    private JButton addButton;
    private List<Habit> habits; // Reference to the user's habit list

    public AddHabitGUI(List<Habit> habits) {
        this.habits = habits; // Initialize the habit list

        frame = new JFrame("Add Habit");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel habitNameLabel = new JLabel("Habit Name:");
        habitNameLabel.setBounds(20, 30, 100, 30);
        frame.add(habitNameLabel);

        habitNameField = new JTextField();
        habitNameField.setBounds(120, 30, 150, 30);
        frame.add(habitNameField);

        addButton = new JButton("Add Habit");
        addButton.setBounds(90, 80, 120, 30);
        frame.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitName = habitNameField.getText();
                if (!habitName.isEmpty()) {
                    // Create a new Habit object and add it to the list
                    Habit newHabit = new Habit(habits.size() + 1, 1, habitName, false); // Example userId = 1
                    habits.add(newHabit);
                    JOptionPane.showMessageDialog(frame, "Habit added: " + habitName);
                    frame.dispose(); // Close the Add Habit window
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a habit name.");
                }
            }
        });

        frame.setVisible(true);
    }
}