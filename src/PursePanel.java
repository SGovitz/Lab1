import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    public PursePanel() {
        this.purse = new Purse();
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.setColor(Color.BLACK);

        int y = 20;
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            g.drawString(count + " x " + denom.name() + " ($" + denom.amt() + ")", 10, y);
            y += 20;
        }

        g.drawString("Total value: $" + String.format("%.2f", purse.getValue()), 10, y);
    }

}