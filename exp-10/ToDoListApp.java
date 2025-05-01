import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame implements ActionListener {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, removeButton;

    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top Panel with input and add button
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        taskField = new JTextField();
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Remove button
        removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(this);

        // Add components to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}
