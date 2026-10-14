package main.com.breakbreak.components;

import main.com.breakbreak.util.ImageCache;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public abstract class GameComponent extends JComponent {

    public GameComponent(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    public void setImage(String name, String filename) {
        try {
            File imgFile = new File("src/main/resources/" + filename);
            if (imgFile.exists()) {
                ImageIcon image = new ImageIcon(imgFile.getAbsolutePath());
                ImageCache.getInstance().addImage(name, image);
            }
        } catch (Exception e) {
            // Sin acciones secundarias
        }
    }

    public abstract ImageIcon getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        ImageIcon icon = getImage();
        if (icon != null && icon.getImage() != null) {
            g2.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);

            if (icon.getDescription() != null && icon.getDescription().contains("background")) {
                g2.setColor(new Color(0, 0, 0, 160));
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        }
        g2.dispose();
    }
}
