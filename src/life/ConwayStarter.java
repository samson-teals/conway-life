package life;

import java.util.Random;

public class ConwayStarter implements LifeGrid {
    int sizeX;
    int sizeY;

    boolean[][] grid;

    public ConwayStarter(int x, int y) {
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
        // implement
    }
}
