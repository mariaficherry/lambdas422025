package Lambdas;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Graphic3 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) {
        Graphic3 design = new Graphic3();
        design.addWindowListener(new WindowAdapter() {
        });
    }

    @SuppressWarnings("deprecation")
    public Graphic3() {
        super("A circle made up of stars by joining them at certain position filled with random colors");
        setBackground(Color.green);
        setSize(450, 450);
        show();
    }

    public void paint(Graphics graphics) {
        int xCoordinates[] = {57, 69, 111, 75, 85, 57, 29, 39, 3, 45};
        int yCoordinates[] = {2, 38, 38, 56, 98, 74, 98, 56, 38, 38};
        Graphics2D graphics2D = (Graphics2D) graphics;
        GeneralPath starFigure = new GeneralPath();
        starFigure.moveTo(xCoordinates[0], yCoordinates[0]);
        for (int j = 1; j < xCoordinates.length; j++)
            starFigure.lineTo(xCoordinates[j], yCoordinates[j]);
        starFigure.closePath();
        graphics2D.translate(200, 200);
        for (int i = 1; i <= 10; i++) {
            graphics2D.rotate(Math.PI / 9.0);
            graphics2D.setColor(new Color((int) (Math.random() * 128), (int) (Math.random() * 128),
                    (int) (Math.random() * 128)));
            graphics2D.fill(starFigure);
        }
    }
}