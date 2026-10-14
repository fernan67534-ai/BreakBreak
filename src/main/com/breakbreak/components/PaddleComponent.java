package main.com.breakbreak.components;

import main.com.breakbreak.util.ImageCache;
import javax.swing.ImageIcon;

public class PaddleComponent extends GameComponent {
    private static final String IMAGE_NAME = "paddle";

    public PaddleComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
        // Cambiado de paddle.webp a paddle.jpg para que lea tu archivo físico
        setImage(IMAGE_NAME, "paddle.jpg");
    }

    @Override
    public ImageIcon getImage() {
        return ImageCache.getInstance().getImage(IMAGE_NAME);
    }
}
