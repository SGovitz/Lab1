import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    public JTextArea purseDisplay;

    public PursePanel() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 400));

        purseDisplay = new JTextArea(20, 30); // 20 rows, 30 columns
        purseDisplay.setEditable(false);
        purseDisplay.setFont(new Font("Monospaced", Font.PLAIN, 12));

        this.add(new JScrollPane(purseDisplay)); // Add scroll pane for long content
    }

    public void updatePurse(Purse purse) {
        purseDisplay.setText(purse.toString());
    }
}
