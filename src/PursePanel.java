import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse; // Represents the contents of the purse

    public PursePanel() {
        this.purse = new Purse(); // Initialize with an empty purse
        this.setBackground(Color.WHITE); // Set background color
        this.setPreferredSize(new Dimension(400, 400)); // Panel size
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel before painting

        if (purse != null) {
            int yPos = 20; // Starting y-position for rendering content
            int xStart = 10; // Starting x-position for rendering images

            for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
                Denomination denom = entry.getKey();
                int count = entry.getValue();

                // Load the image for this denomination
                ImageIcon icon = new ImageIcon(denom.img());
                Image img = icon.getImage();

                // Determine image size based on the form (bill or coin)
                int imageWidth = denom.form().equalsIgnoreCase("bill") ? 125 : 50;
                int imageHeight = 50;

                // Render multiple images based on the count
                for (int i = 0; i < count; i++) {
                    int tempX = xStart + (i % 11) * (imageWidth + 10); // Wrap after 10 images per row
                    int tempY = yPos + (i / 11) * (imageHeight + 20);  // Move down for new rows
                    g.drawImage(img, tempX, tempY, imageWidth, imageHeight, this); // Draw the image
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

    public void updatePurse(Purse newPurse) {
        this.purse = newPurse; // Update the purse with new content
        repaint(); // Trigger repaint to show updated content
    }
}
