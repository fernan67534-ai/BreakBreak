package main.com.breakbreak.components;

import main.com.breakbreak.util.ImageCache;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BorderComponent extends GameComponent {

    public BorderComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
        setImage("corner-tl", "corner-tl.png");
        setImage("corner-tr", "corner-tr.png");
        setImage("corner-bl", "corner-bl.png");
        setImage("corner-br", "corner-br.png");
        setImage("edge-t", "edge-t.png");
        setImage("edge-b", "edge-b.png");
        setImage("edge-l", "edge-l.png");
        setImage("edge-r", "edge-r.png");
    }

    @Override
    public ImageIcon getImage() {
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        ImageCache cache = ImageCache.getInstance();
        ImageIcon tl = cache.getImage("corner-tl");
        ImageIcon tr = cache.getImage("corner-tr");
        ImageIcon bl = cache.getImage("corner-bl");
        ImageIcon br = cache.getImage("corner-br");
        ImageIcon t = cache.getImage("edge-t");
        ImageIcon b = cache.getImage("edge-b");
        ImageIcon l = cache.getImage("edge-l");
        ImageIcon r = cache.getImage("edge-r");

        int w = getWidth();
        int h = getHeight();
        int size = 26;

        // 1. Dibujar los conectores lineales Art Deco escalados
        if (t != null && t.getImage() != null) g2.drawImage(t.getImage(), 0, 0, w, size, this);
        if (b != null && b.getImage() != null) g2.drawImage(b.getImage(), 0, h - size, w, size, this);
        if (l != null && l.getImage() != null) g2.drawImage(l.getImage(), 0, 0, size, h, this);
        if (r != null && r.getImage() != null) g2.drawImage(r.getImage(), w - size, 0, size, h, this);

        // 2. Dibujar las esquinas ornamentales doradas adaptadas al tamaño
        if (tl != null && tl.getImage() != null) g2.drawImage(tl.getImage(), 0, 0, size, size, this);
        if (tr != null && tr.getImage() != null) g2.drawImage(tr.getImage(), w - size, 0, size, size, this);
        if (bl != null && bl.getImage() != null) g2.drawImage(bl.getImage(), 0, h - size, size, size, this);
        if (br != null && br.getImage() != null) g2.drawImage(br.getImage(), w - size, h - size, size, size, this);

        // ¡INTEGRACIÓN DEL MARGEN DERECHO!: Pintamos el divisor continuo al extremo derecho exacto
        g2.setColor(new Color(55, 55, 65)); // Gris sutil idéntico al panel
        g2.fillRect(w - 4, 0, 4, h); // Línea vertical de 4px de ancho de arriba a abajo

        g2.dispose();
    }
}
