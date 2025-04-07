package Lambdas;

import javax.swing.*;
import java.awt.*;

public class PixelArt extends JFrame {
    private static final long serialVersionUID = 1L;

    public PixelArt() {
        setTitle("Java Pixel Art");
        setSize(220, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PixelPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PixelArt::new);
    }

    class PixelPanel extends JPanel {
        private static final int PIXEL_SIZE = 20;

        // A 2D array representing a smiley face
        private final Color[][] pixels = {
                {null, null, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, null, null},
                {null, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, null},
                {Color.YELLOW, Color.YELLOW, Color.BLACK, Color.YELLOW, Color.YELLOW, Color.BLACK, Color.YELLOW, Color.YELLOW},
                {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
                {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
                {Color.YELLOW, Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.YELLOW, Color.YELLOW},
                {null, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, null},
                {null, null, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, null, null}
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int row = 0; row < pixels.length; row++) {
                for (int col = 0; col < pixels[row].length; col++) {
                    Color color = pixels[row][col];
                    if (color != null) {
                        g.setColor(color);
                        g.fillRect(col * PIXEL_SIZE, row * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
                    }
                }
            }
        }
    }
}

