package Lambdas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.colorchooser.ColorChooserComponentFactory;

public class PixelArtGridEditor extends JFrame {
    private static final long serialVersionUID = 1L;

    // Set the grid size
    private static final int GRID_SIZE = 16; // 16x16 grid for simplicity
    private static final int CELL_SIZE = 30; // Each cell size in pixels

    // 2D array to hold the colors for each cell
    private Color[][] pixelGrid = new Color[GRID_SIZE][GRID_SIZE];
    private Color currentColor = Color.BLACK;

    public PixelArtGridEditor() {
        setTitle("Pixel Art Grid Editor");
        setSize(GRID_SIZE * CELL_SIZE + 50, GRID_SIZE * CELL_SIZE + 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the grid with white colors
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                pixelGrid[i][j] = Color.WHITE;
            }
        }

        // Panel for the grid
        JPanel gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < GRID_SIZE; i++) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        g.setColor(pixelGrid[i][j]);
                        g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        g.setColor(Color.BLACK);
                        g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
            }
        };
        gridPanel.setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        gridPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / CELL_SIZE;
                int y = e.getY() / CELL_SIZE;
                // Change the color of the clicked cell
                pixelGrid[y][x] = currentColor;
                repaint();
            }
        });

        // Color chooser button
        JButton colorButton = new JButton("Pick Color");
        colorButton.addActionListener(e -> {
            // Open a color picker dialog to select a color
            Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", currentColor);
            if (selectedColor != null) {
                currentColor = selectedColor;
            }
        });

        // Layout
        JPanel controlPanel = new JPanel();
        controlPanel.add(colorButton);
        getContentPane().add(gridPanel, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PixelArtGridEditor::new);
    }
}

