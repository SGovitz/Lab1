import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    public Register register;
    public JPanel inputPanel;
    public JTextField input;
    public PursePanel changePanel;

    RegisterPanel() {
        register = new Register();
        inputPanel = new JPanel();
        input = new JTextField();
        changePanel = new PursePanel();
/*
        this.setBackground(Color.BLUE);
        flipButton.setBackground(Color.RED);
        flipButton.setForeground(Color.WHITE);
        flipButton.addActionListener(new FlipListener());

        this.setPreferredSize(new Dimension(500, 500));

        this.add(flipButton);
        this.add(coinLabel);
        */
    }
/*
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }


    }
    */


}