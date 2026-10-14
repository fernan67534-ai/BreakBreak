package main.com.breakbreak.components;

import main.com.breakbreak.util.ImageCache;
import javax.swing.ImageIcon;

public class BallComponent extends GameComponent {
    private static final String IMAGE_NAME = "ball";

    public BallComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
        setImage(IMAGE_NAME, "ball.gif");
    }

    @Override
    public ImageIcon getImage() {
        return ImageCache.getInstance().getImage(IMAGE_NAME);
    }
}
