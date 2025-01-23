import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        // Initialize components
        register = new Register();
        inputPanel = new JPanel();
        input = new JTextField(10); // 10-column wide text field
        changePanel = new PursePanel();

        // Configure layout and styles
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(500, 500));

        inputPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setPreferredSize(new Dimension(300, 50));

        // Add components to inputPanel
        JLabel inputLabel = new JLabel("Enter amount: ");
        JButton submitButton = new JButton("Get Change");
        submitButton.addActionListener(new InputListener());

        inputPanel.add(inputLabel);
        inputPanel.add(input);
        inputPanel.add(submitButton);

        // Add panels to RegisterPanel
        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);
    }

    // Action listener for the submit button
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
                    return;
                }

                Purse purse = register.makeChange(amount);

                // Update the PursePanel with calculated change
                changePanel.updatePurse(purse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
