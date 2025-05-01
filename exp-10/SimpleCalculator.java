import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String firstNumber = "";
    private String operator = "";
    private boolean startNewNumber = false;

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If digit or decimal
        if (command.matches("[0-9]")) {
            if (startNewNumber) {
                display.setText(command);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        }
        // If operator
        else if (command.matches("[\\+\\-\\*/]")) {
            firstNumber = display.getText();
            operator = command;
            startNewNumber = true;
        }
        // If equals
        else if (command.equals("=")) {
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = (num2 != 0) ? num1 / num2 : 0; break;
            }

            display.setText(String.valueOf(result));
            startNewNumber = true;
        }
        // Clear
        else if (command.equals("C")) {
            display.setText("");
            firstNumber = "";
            operator = "";
            startNewNumber = false;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
