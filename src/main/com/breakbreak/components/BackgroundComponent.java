package main.com.breakbreak.components;

import main.com.breakbreak.util.ImageCache;
import javax.swing.ImageIcon;

public class BackgroundComponent extends GameComponent {
    private static final String IMAGE_NAME = "background";

    public BackgroundComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
        setImage(IMAGE_NAME, "background.gif");

        ImageIcon icon = ImageCache.getInstance().getImage(IMAGE_NAME);
        if (icon != null) {
            icon.setDescription("background");
        }
    }

    @Override
    public ImageIcon getImage() {
        return ImageCache.getInstance().getImage(IMAGE_NAME);
    }
}
