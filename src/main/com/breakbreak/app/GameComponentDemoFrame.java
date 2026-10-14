package main.com.breakbreak.app;

import main.com.breakbreak.components.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameComponentDemoFrame {

    private JFrame frame;

    public GameComponentDemoFrame() {
        // Inicializamos el contenedor JFrame en Swing nativo puro
        frame = new JFrame("BreakBreak - Vertical Layout con Bordes Art Deco");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ¡SOLUCIÓN!: Ajustamos las dimensiones a 780x750 para dar el espacio exacto
        // al margen derecho útil y evitar que se congele el proceso por falta de espacio
        frame.setSize(780, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.setBackground(new Color(23, 23, 28));

        // MARGEN CONTINUO EXTERIOR: Bordes nítidos de la ventana completa
        rootPanel.setBorder(BorderFactory.createLineBorder(new Color(45, 45, 55), 6));

        // ==========================================
        // 1. ÁREA DE JUEGO VERTICAL (LADO IZQUIERDO)
        // ==========================================
        JPanel gameArea = new JPanel(null);
        gameArea.setPreferredSize(new Dimension(460, 700));
        gameArea.setBackground(new Color(30, 30, 35));

        // CAPA DELANTERA 1: Pelota grande y Barra perfectamente centradas simétricamente en los nuevos 460px
        gameArea.add(new BallComponent(219, 380, 45, 45));
        gameArea.add(new PaddleComponent(162, 540, 160, 24));

        // CAPA DELANTERA 2: Matriz de bloques ALEATORIA perfectamente equilibrada de 5x5
        int blockWidth = 76;
        int blockHeight = 22;
        int startX = 31; // Margen exacto revisado para centrar las 5 columnas simétricamente
        int startY = 55;
        int gapX = 6;
        int gapY = 8;

        // DECLARACIÓN REVISADA: Arreglo explícito con corchetes [] colocado correctamente
        BlockComponent.BlockType[] types = BlockComponent.BlockType.values();
        Random random = new Random();

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                int bx = startX + col * (blockWidth + gapX);
                int by = startY + row * (blockHeight + gapY);

                BlockComponent.BlockType randomType = types[random.nextInt(types.length)];
                gameArea.add(new BlockComponent(bx, by, blockWidth, blockHeight, randomType));
            }
        }

        // CAPA INTERMEDIA: El marco Art Deco adaptado al nuevo ancho que incluye el divisor derecho continuo
        BorderComponent artDecoBorder = new BorderComponent(0, 0, 460, 700);
        gameArea.add(artDecoBorder);

        // CAPA TRASERA: El fondo animado del Titán Colosal escalado sin recortes
        BackgroundComponent bg = new BackgroundComponent(0, 0, 460, 700);
        gameArea.add(bg);

        rootPanel.add(gameArea, BorderLayout.CENTER);

        // ==========================================
        // 2. PANEL HUD VERTICAL (LADO DERECHO)
        // ==========================================
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setPreferredSize(new Dimension(300, 700));
        sidePanel.setBackground(new Color(23, 23, 28));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 30));

        JLabel lblGameTitle = new JLabel("BREAKBREAK");
        lblGameTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblGameTitle.setForeground(Color.WHITE);
        lblGameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(lblGameTitle);

        sidePanel.add(Box.createVerticalStrut(40));

        JLabel lblPuntuacion = new JLabel("PUNTUACIÓN");
        lblPuntuacion.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPuntuacion.setForeground(Color.GRAY);
        lblPuntuacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(lblPuntuacion);

        sidePanel.add(Box.createVerticalStrut(5));

        JLabel lblScoreVal = new JLabel("0000");
        lblScoreVal.setFont(new Font("Segoe UI", Font.BOLD, 46));
        lblScoreVal.setForeground(Color.WHITE);
        lblScoreVal.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(lblScoreVal);

        sidePanel.add(Box.createVerticalStrut(30));

        JLabel lblVidas = new JLabel("VIDAS");
        lblVidas.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblVidas.setForeground(Color.GRAY);
        lblVidas.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(lblVidas);

        sidePanel.add(Box.createVerticalStrut(10));

        JPanel livesContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        livesContainer.setOpaque(false);
        livesContainer.setMaximumSize(new Dimension(220, 40));

        livesContainer.add(new HeartComponent(0, 0, 32, 32, true));
        livesContainer.add(new HeartComponent(0, 0, 32, 32, true));
        livesContainer.add(new HeartComponent(0, 0, 32, 32, false));
        sidePanel.add(livesContainer);

        sidePanel.add(Box.createVerticalGlue());

        MaterialButton btnPlay = new MaterialButton("JUGAR");
        btnPlay.setMaximumSize(new Dimension(220, 42));
        btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);

        MaterialButton btnExit = new MaterialButton("SALIR");
        btnExit.setMaximumSize(new Dimension(220, 42));
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.addActionListener(e -> System.exit(0));

        sidePanel.add(btnPlay);
        sidePanel.add(Box.createVerticalStrut(15));
        sidePanel.add(btnExit);

        rootPanel.add(sidePanel, BorderLayout.EAST);
        frame.add(rootPanel);
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameComponentDemoFrame demo = new GameComponentDemoFrame();
            demo.showWindow();
        });
    }
}
