import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    // GUI components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginForm() {
        // Frame title
        setTitle("Login Form");

        // Layout manager
        setLayout(new GridLayout(4, 2, 10, 10));
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);

        // Add components to frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel("")); // Empty cell
        add(loginButton);
        add(new JLabel("")); // Empty cell
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Validate credentials
        if (username.equals("admin") && password.equals("password")) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Login successful!");
        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
