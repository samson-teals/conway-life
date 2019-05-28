package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    LifeGrid grid;

    /**
     * The GridCanvas nested class is only used for drawing. No calculations should be done here.
     */
    class GridCanvas extends Canvas {
        int squareSize;
        int windowOffset;

        public GridCanvas(int width, int height, int squareSize, int windowOffset) {
            setBackground(Color.WHITE);
            setSize(width * squareSize, windowOffset + height * squareSize);

            this.squareSize = squareSize;
            this.windowOffset = windowOffset;
        }

        /**
         * This method paints the canvas and is called by the system whenever a repaint is requested.
         */
        public void paint(Graphics g) {
            paintGrid(g);
        }

        /**
         * Render the Life grid.
         */
        private void paintGrid(Graphics g) {
            for (int i = 0; i < grid.getSizeX(); i++) {
                for (int j = 0; j < grid.getSizeY(); j++) {
                    if (grid.isAlive(i, j)) {
                        g.setColor(Color.red);
                        g.fillRect(i * squareSize, windowOffset + j * squareSize, squareSize, squareSize);
                    }
                }
            }
        }
    }

    public Main(LifeGrid grid, int squareSize, float framesPerSecond) {
        // Save the grid so that we can paint with it later
        this.grid = grid;

        // sets up graphics
        Frame frame = new Frame("Conway's Game of Life");
        frame.setVisible(true);
        Insets insets = frame.getInsets();

        Canvas canvas = new GridCanvas(grid.getSizeX(), grid.getSizeY(), squareSize, insets.top);
        frame.add(canvas);
        frame.setLayout(null);
        frame.setSize(canvas.getWidth(), canvas.getHeight());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // sets up timer so that we can animate the life grid
        int frameDelay = (int) (1000 / framesPerSecond);
        Timer timer = new Timer(frameDelay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grid.iterate();
                canvas.repaint();
            }
        });
        timer.start();
    }

    public static void main(String args[]) {
        int gridWidth = 50;
        int gridHeight = 40;
        int squareSize = 10;
        int framesPerSecond = 10;

        LifeGrid grid = new Sweep(gridWidth, gridHeight);
        grid.init();

        new Main(grid, squareSize, framesPerSecond);
    }
}
