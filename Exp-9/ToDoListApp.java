import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, removeButton;

    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Initialize components
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        // Panel for input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Add components to the frame
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Add task on button click
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        });

        // Remove selected tasks on button click
        removeButton.addActionListener(e -> {
            int[] selectedIndices = taskList.getSelectedIndices();
            if (selectedIndices.length > 0) {
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    taskListModel.removeElementAt(selectedIndices[i]);
                }
            }
        });

        // Pressing Enter in the text field adds the task
        taskField.addActionListener(e -> addButton.doClick());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoListApp().setVisible(true);
        });
    }
}
