import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        this.purse = new Purse();
        // Set background color
        this.setBackground(Color.WHITE);
        // Panel size
        this.setPreferredSize(new Dimension(400, 400));
    }

    // Redraw the panel when the purse is updated
    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        // Clear the panel before painting
        super.paintComponent(g);

        if (purse != null) {
            // Starting y-position for rendering content
            int yPos = 20;
            // Starting x-position for rendering images
            int xStart = 10;

            for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
                Denomination denom = entry.getKey();
                int count = entry.getValue();

                // Load the image for this denomination
                ImageIcon icon = new ImageIcon(denom.img());
                Image img = icon.getImage();

                // Change Image Width of bill to be slightly larger
                int imageWidth = denom.form().equalsIgnoreCase("bill") ? 125 : 50;
                int imageHeight = 50;

                // Render multiple images based on the count
                for (int i = 0; i < count; i++) {
                    int tempX = xStart + (i % 11) * (imageWidth + 10);
                    int tempY = yPos + (i / 11) * (imageHeight + 20);
                    g.drawImage(img, tempX, tempY, imageWidth, imageHeight, this);
                }

                // Draw text below the row of images
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospaced", Font.PLAIN, 14));
                g.drawString(count + " x " + denom.name() + " ($" + String.format("%.2f", denom.amt()) + ")", xStart, yPos + ((count + 9) / 10) * (imageHeight + 20));

                yPos += ((count + 9) / 10) * (imageHeight + 20) + 20; // Adjust yPos for the next denomination
            }

            // Draw the total value at the bottom
            g.setFont(new Font("Monospaced", Font.BOLD, 16));
            g.drawString("Total value: $" + String.format("%.2f", purse.getValue()), 10, yPos + 20);
        }
    }

}
