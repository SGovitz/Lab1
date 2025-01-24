import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    public Register register = new Register();
    public JPanel inputPanel = new JPanel();
    public JTextField input = new JTextField(10);
    public PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        // Configure layout and styles
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(500, 500));

        inputPanel.setBackground(Color.CYAN);
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
    public class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(input.getText());
                if (amount <= 0 || amount == 0.00001) {
                    // If the amount is less than or equal to zero, show "Empty Purse"
                    changePanel.setPurse(new Purse());
                    JOptionPane.showMessageDialog(RegisterPanel.this, "Empty Purse");
                } else {
                    // Generate the change and update the purse panel
                    Purse purse = register.makeChange(amount);
                    changePanel.setPurse(purse);
                }
        }
    }
}
