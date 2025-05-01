import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginForm() {
        // Frame settings
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Username
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        // Password
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Empty label for spacing
        add(new JLabel());

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(loginButton);

        // Message label
        messageLabel = new JLabel("", JLabel.CENTER);
        add(messageLabel);

        // Fill last grid cell
        add(new JLabel());

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("password")) {
            messageLabel.setText("Login Successful!");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel.setText("Invalid credentials.");
            messageLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}
