package Lambdas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Graphic2 extends JFrame {
    private static final long serialVersionUID = 1L;

    public Graphic2() {
        super("Geometric Shapes");

        // Set up the custom drawing panel
        DrawPanel panel = new DrawPanel();
        panel.setPreferredSize(new Dimension(500, 220));
        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Graphic2::new);
    }

    // Inner class for drawing
    private static class DrawPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Anti-aliasing for smoother shapes
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Gradient ellipse
            g2d.setPaint(new GradientPaint(16, 30, Color.RED, 45, 105, Color.GREEN, true));
            g2d.fill(new Ellipse2D.Double(6, 31, 61, 105));

            // Black rectangle with thick border
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(9.0f));
            g2d.draw(new Rectangle2D.Double(82, 32, 67, 102));

            // Texture painted rounded rectangle
            BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
            Graphics2D biGraphics = bi.createGraphics();
            biGraphics.setColor(Color.BLUE);
            biGraphics.fillRect(0, 0, 9, 9);
            biGraphics.setColor(Color.ORANGE);
            biGraphics.drawRect(2, 2, 7, 7);
            biGraphics.setColor(Color.BLACK);
            biGraphics.fillRect(2, 2, 4, 4);
            biGraphics.setColor(Color.PINK);
            biGraphics.fillRect(5, 5, 2, 2);

            g2d.setPaint(new TexturePaint(bi, new Rectangle(9, 9)));
            g2d.fill(new RoundRectangle2D.Double(156, 31, 76, 101, 51, 51));

            // Cyan arc
            g2d.setPaint(Color.CYAN);
            g2d.setStroke(new BasicStroke(7.0f));
            g2d.draw(new Arc2D.Double(240, 30, 75, 100, 0, 270, Arc2D.PIE));

            // Red line
            g2d.setPaint(Color.RED);
            g2d.draw(new Line2D.Double(400, 40, 350, 180));

            // Dashed black line
            float[] dashes = {20};
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10, dashes, 0));
            g2d.draw(new Line2D.Double(320, 30, 395, 150));
        }
    }
}