package Lambdas;

import javax.swing.JFrame;
import java.awt.*;       // AWT package is responsible for creating GUI
import javax.swing.*;    // Java swing package is responsible to provide UI components

public class Graphic1 extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final int SAMPLE_CANVAS_WIDTH = 500;
    public static final int SAMPLE_CANVAS_HEIGHT = 500;

    // Inner canvas class instance
    private DrawCanvas sampleCanvas;

    // Constructor (correct name, no return type)
    public Graphic1() {
        sampleCanvas = new DrawCanvas();
        sampleCanvas.setPreferredSize(new Dimension(SAMPLE_CANVAS_WIDTH, SAMPLE_CANVAS_HEIGHT));
        Container containerPane = getContentPane();
        containerPane.add(sampleCanvas);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setTitle("Java Graphics Sample");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graphic1());
    }

    // Inner class for drawing
    private class DrawCanvas extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            setBackground(Color.BLACK);

            graphics.setColor(Color.GREEN);
            graphics.drawLine(30, 40, 100, 200);
            graphics.drawOval(150, 180, 10, 10);
            graphics.drawRect(200, 210, 20, 30);

            graphics.setColor(Color.MAGENTA);
            graphics.fillOval(300, 310, 30, 50);
            graphics.fillRect(400, 350, 60, 50);

            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Monospaced", Font.PLAIN, 12));
            graphics.drawString("Java Graphics in 2D ...", 10, 20);
        }
    }
}