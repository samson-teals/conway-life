package life;

public class Sweep implements LifeGrid {
    int sizeX;
    int sizeY;

    int count;

    public Sweep(int x, int y) {
        sizeX = x;
        sizeY = y;

        count = 0;
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
        return (x == (count % sizeX)) || (y == (count % sizeY));
    }

    @Override
    public void init() {
        count = 0;
    }

    @Override
    public void iterate() {
        count++;
    }
}
