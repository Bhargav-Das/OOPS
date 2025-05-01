import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeManager extends JFrame {
    // UI Components
    private JTextField idField, nameField, deptField, salaryField;
    private JButton insertButton, retrieveButton;
    private JTable table;
    private DefaultTableModel tableModel;

    // JDBC Connection info
    private final String DB_URL = "jdbc:mysql://localhost:3306/company";
    private final String DB_USER = "root";         // Change as needed
    private final String DB_PASSWORD = "password"; // Change as needed

    public EmployeeManager() {
        setTitle("Employee Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 5, 5));
        idField = new JTextField();
        nameField = new JTextField();
        deptField = new JTextField();
        salaryField = new JTextField();

        insertButton = new JButton("Insert");
        retrieveButton = new JButton("Retrieve");

        inputPanel.add(new JLabel("ID"));
        inputPanel.add(new JLabel("Name"));
        inputPanel.add(new JLabel("Department"));
        inputPanel.add(new JLabel("Salary"));
        inputPanel.add(new JLabel()); // filler

        inputPanel.add(idField);
        inputPanel.add(nameField);
        inputPanel.add(deptField);
        inputPanel.add(salaryField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        buttonPanel.add(retrieveButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Department", "Salary"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        // Insert action
        insertButton.addActionListener(e -> insertEmployee());

        // Retrieve action
        retrieveButton.addActionListener(e -> retrieveEmployees());
    }

    private void insertEmployee() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.setString(2, nameField.getText());
            stmt.setString(3, deptField.getText());
            stmt.setDouble(4, Double.parseDouble(salaryField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee inserted successfully!");
            clearFields();
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, "Employee ID already exists!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void retrieveEmployees() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            tableModel.setRowCount(0); // Clear existing data

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");
                tableModel.addRow(new Object[]{id, name, dept, salary});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeManager().setVisible(true));
    }
}
