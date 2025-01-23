import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    public Register register;
    public JPanel inputPanel;
    public JTextField input;
    public PursePanel changePanel;

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
    public class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(input.getText());

                Purse purse = register.makeChange(amount);

                //Add purse is empty

                // Update the PursePanel with calculated change
                changePanel.updatePurse(purse);
        }
    }
}
