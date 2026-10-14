package main.com.breakbreak.components;

import main.com.breakbreak.util.ImageCache;
import javax.swing.ImageIcon;
import java.awt.Dimension; // Importación necesaria para las dimensiones

public class HeartComponent extends GameComponent {
    private static final String IMG_FULL = "heart-full";
    private static final String IMG_EMPTY = "heart-empty";
    private boolean isAlive;

    public HeartComponent(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height);
        this.isAlive = isAlive;

        // Sincronizado con tus nombres reales de archivo en resources
        setImage(IMG_FULL, "heart.png");
        setImage(IMG_EMPTY, "heart-empty.png");

        // ¡SOLUCIÓN! Forzamos a que el layout respete las dimensiones del corazón
        setPreferredSize(new Dimension(width, height));
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
        repaint();
    }

    @Override
    public ImageIcon getImage() {
        if (isAlive) {
            return ImageCache.getInstance().getImage(IMG_FULL);
        } else {
            return ImageCache.getInstance().getImage(IMG_EMPTY);
        }
    }
}
