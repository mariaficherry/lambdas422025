package Lambdas;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Graphic5 extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Frame windowFrame;
    TextField sampleText;
    Font sampleFont;
    Color colorOfText;
    Color colorOfCircle;

    public static void main(String args[]) {
        Graphic5 start;
        start = new Graphic5();
    }

    public Graphic5() {
        this("Arial", Font.BOLD, 18, Color.gray, Color.red);
    }

    public Graphic5(String ff, int fs, int fz, Color bg, Color fg) {
        setBackground(bg);
        colorOfCircle = Color.green.brighter();
        colorOfText = fg;
        sampleFont = new Font(ff, fs, fz);
        sampleText = new TextField("eduCBA (Corporate Bridge Consultancy Pvt Ltd) ");
        windowFrame = new Frame("Demo");
        windowFrame.add(sampleText, BorderLayout.NORTH);
        windowFrame.add(this, BorderLayout.CENTER);
        windowFrame.setSize(new Dimension(300, 340));
        windowFrame.setLocation(150, 140);
        windowFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        sampleText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        });
        windowFrame.setVisible(true);
    }

    public void paint(Graphics graphics) {
        String sampleTxt = sampleText.getText();
        if (sampleTxt.length() == 0) return;
        if (graphics instanceof Graphics2D) {
            Dimension dimension = getSize();
            Point point = new Point(dimension.width / 2, dimension.height / 2);
            int radius = (int) (point.x * 0.84);
            graphics.setColor(colorOfCircle);
            graphics.drawArc(point.x - radius, point.y - radius,
                    radius * 2 - 1, radius * 2 - 1,
                    0, 360);
            graphics.setColor(colorOfText);
            graphics.setFont(sampleFont);
            CircularText((Graphics2D) graphics, sampleTxt, point, radius, -Math.PI / 2, 1.0);
        } else {
            System.out.println("Some Error Occurred");
        }
    }

    static void CircularText(Graphics2D graphics, String sampleTxt, Point center,
                             double radius, double length, double height) {
        double circleAngle = length;
        Point2D circle = new Point2D.Double(center.x, center.y);
        char chArray[] = sampleTxt.toCharArray();
        FontMetrics fm = graphics.getFontMetrics();
        AffineTransform formx, formy;
        formx = AffineTransform.getTranslateInstance(circle.getX(), circle.getY());
        for (int i = 0; i < chArray.length; i++) {
            double cwid = (double) (getWidth(chArray[i], fm));
            if (!(chArray[i] == ' ' || Character.isSpaceChar(chArray[i]))) {
                cwid = (double) (fm.charWidth(chArray[i]));
                formy = new AffineTransform(formx);
                formy.rotate(circleAngle, 0.0, 0.0);
                String chstr = new String(chArray, i, 1);
                graphics.setTransform(formy);
                graphics.drawString(chstr, (float) (-cwid / 2), (float) (-radius));
            }
            if (i < (chArray.length - 1)) {
                double adv = cwid / 2.0 + fm.getLeading() + getWidth(chArray[i + 1], fm) / 2.0;
                circleAngle += Math.sin(adv / radius);
            }
        }
    }

    static int getWidth(char charText, FontMetrics fontMetrics) {
        if (charText == ' ' || Character.isSpaceChar(charText)) {
            return fontMetrics.charWidth('n');
        } else {
            return fontMetrics.charWidth(charText);
        }
    }
}