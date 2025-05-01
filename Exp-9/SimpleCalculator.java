import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;

    public SimpleCalculator() {
        // Initialize input
        input = new StringBuilder();

        // Set up the frame
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Button labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();

        switch (value) {
            case "C":
                input.setLength(0);
                display.setText("");
                break;
            case "=":
                if (input.length() == 0) {
                    display.setText("Error");
                    return;
                }
                try {
                    double result = evaluate(input.toString());
                    display.setText(String.valueOf(result));
                    input.setLength(0);
                } catch (Exception ex) {
                    display.setText("Error");
                    input.setLength(0);
                }
                break;
            default:
                input.append(value);
                display.setText(input.toString());
                break;
        }
    }

    // Simple evaluation of expressions
    private double evaluate(String expression) {
        // Using ScriptEngine for simple evaluation
        try {
            javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Object result = engine.eval(expression);

            // Check for division by zero
            if (expression.contains("/0")) {
                throw new ArithmeticException("Division by zero");
            }

            return Double.parseDouble(result.toString());
        } catch (ArithmeticException e) {
            throw new RuntimeException("Division by zero");
        } catch (Exception e) {
            throw new RuntimeException("Invalid Expression");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
