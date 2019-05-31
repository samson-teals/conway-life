package life;

import java.util.Random;

public class ConwayStarter2 implements LifeGrid {
    int sizeX;
    int sizeY;

    boolean[][] grid;

    public ConwayStarter2(int x, int y) {
        sizeX = x;
        sizeY = y;

        grid = new boolean[sizeX][sizeY];
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public boolean isAlive(int x, int y) {
        return grid[x][y];
    }

    @Override
    public void init() {
        long unixTime = System.currentTimeMillis() / 1000;
        Random rand = new Random(unixTime);

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grid[i][j] = rand.nextBoolean();
            }
        }
    }

    /**
     * Implement the rules to Conway's Game of Life:
     *
     * 1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
     * 2. Any live cell with two or three live neighbours lives on to the next generation.
     * 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
     * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */
    @Override
    public void iterate() {
        boolean[][] tempGrid = new boolean[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                // calculate the next state
                boolean nextState = false;

                // put in some conditions and call countNeighbours to implement the "life" rules

                // the following example condition is not correct and generates a pattern of vertical stripes
                if (i % 2 == 0) {
                    nextState = true;
                }

                tempGrid[i][j] = nextState;
            }
        }

        // copy the tempGrid back to the grid
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                // copy tempGrid back into grid
                grid[i][j] = tempGrid[i][j];
            }
        }
    }

    /**
     * Count the number of neighbours at grid position (x, y) and return it.
     *
     * If you use a tempGrid, and don't modify the class grid variable, you can use the grid variable directly in your
     * calculations.
     *
     * Remember that you'll need to handle negative numbers. You can assume that either out-of-bounds cells are:
     * - always dead (or always alive)
     * - wrapped-around to the other side of the board (the % operator may be helpful if you do this)
     */
    int countNeighbours(int x, int y) {
        int count = 0;

        // implement


        return count;
    }
}
