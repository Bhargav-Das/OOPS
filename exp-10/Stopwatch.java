import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int elapsedSeconds = 0;
    private boolean running = false;

    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Time label
        timeLabel = new JLabel("Elapsed Time: 0 s", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Timer (fires every 1000ms = 1 second)
        timer = new Timer(1000, e -> {
            elapsedSeconds++;
            updateTimeLabel();
        });

        setVisible(true);
    }

    private void updateTimeLabel() {
        timeLabel.setText("Elapsed Time: " + elapsedSeconds + " s");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == startButton) {
            if (!running) {
                timer.start();
                running = true;
            }
        } else if (source == stopButton) {
            if (running) {
                timer.stop();
                running = false;
            }
        } else if (source == resetButton) {
            timer.stop();
            running = false;
            elapsedSeconds = 0;
            updateTimeLabel();
        }
    }

    public static void main(String[] args) {
        new Stopwatch();
    }
}
