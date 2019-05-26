package life;

public interface LifeGrid {
    public int getSizeX();
    public int getSizeY();

    /**
     * Return true if the cell at (x, y) is alive.
     */
    public boolean isAlive(int x, int y);

    /**
     * Initializes grid.
     */
    public void init();

    /**
     * Calculates next grid iteration.
     */
    public void iterate();
}
