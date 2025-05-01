import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JLabel nameError, emailError, passwordError, confirmError, resultMessage;
    private JButton registerButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 3, 5, 5));

        // Name
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        nameError = new JLabel();
        nameError.setForeground(Color.RED);
        add(nameError);

        // Email
        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);
        emailError = new JLabel();
        emailError.setForeground(Color.RED);
        add(emailError);

        // Password
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);
        passwordError = new JLabel();
        passwordError.setForeground(Color.RED);
        add(passwordError);

        // Confirm Password
        add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);
        confirmError = new JLabel();
        confirmError.setForeground(Color.RED);
        add(confirmError);

        // Register Button
        add(new JLabel(""));
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        add(registerButton);
        add(new JLabel(""));

        // Result message
        resultMessage = new JLabel("", SwingConstants.CENTER);
        resultMessage.setForeground(new Color(0, 128, 0));
        add(new JLabel(""));
        add(resultMessage);
        add(new JLabel(""));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear previous error messages
        nameError.setText("");
        emailError.setText("");
        passwordError.setText("");
        confirmError.setText("");
        resultMessage.setText("");

        boolean valid = true;
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (name.isEmpty()) {
            nameError.setText("Name is required");
            valid = false;
        }
        if (email.isEmpty()) {
            emailError.setText("Email is required");
            valid = false;
        } else if (!email.contains("@")) {
            emailError.setText("Invalid email");
            valid = false;
        }
        if (password.isEmpty()) {
            passwordError.setText("Password is required");
            valid = false;
        }
        if (confirmPassword.isEmpty()) {
            confirmError.setText("Confirm your password");
            valid = false;
        } else if (!password.equals(confirmPassword)) {
            confirmError.setText("Passwords do not match");
            valid = false;
        }

        if (valid) {
            resultMessage.setText("Registration successful!");
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
