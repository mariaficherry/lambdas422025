package Lambdas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Graphic4 extends JFrame {
    private static final long serialVersionUID = 1L;

    public Graphic4() {
        super("Stars Circling Around");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel panel = new DrawPanel();
        add(panel);
        setLocationRelativeTo(null); // center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Graphic3::new);
    }

    class DrawPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private double angleOffset = 0; // rotation around the circle

        public DrawPanel() {
            Timer timer = new Timer(40, e -> {
                angleOffset += 0.05; // update angle for animation
                repaint();
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = 120;
            int numStars = 10;

            Shape star = createStarShape();

            for (int i = 0; i < numStars; i++) {
                double angle = angleOffset + (2 * Math.PI / numStars) * i;
                double x = centerX + radius * Math.cos(angle);
                double y = centerY + radius * Math.sin(angle);

                AffineTransform transform = new AffineTransform();
                transform.translate(x, y);
                transform.translate(-57 / 2.0, -98 / 2.0); // center the star shape

                g2d.setColor(new Color(
                        (int) (Math.random() * 128),
                        (int) (Math.random() * 128),
                        (int) (Math.random() * 128)));
                g2d.fill(transform.createTransformedShape(star));
            }
        }

        // Method to create the star shape
        private Shape createStarShape() {
            int[] xPoints = {57, 69, 111, 75, 85, 57, 29, 39, 3, 45};
            int[] yPoints = {2, 38, 38, 56, 98, 74, 98, 56, 38, 38};

            GeneralPath star = new GeneralPath();
            star.moveTo(xPoints[0], yPoints[0]);
            for (int i = 1; i < xPoints.length; i++) {
                star.lineTo(xPoints[i], yPoints[i]);
            }
            star.closePath();
            return star;
        }
    }
}
