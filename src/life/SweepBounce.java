package life;

public class SweepBounce implements LifeGrid {
    int sizeX;
    int sizeY;

    int count;

    public SweepBounce(int x, int y) {
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
        int size2X = 2 * sizeX;
        int size2Y = 2 * sizeY;

        int countX = count % size2X;
        int countY = count % size2Y;

        boolean activeX = (x == countX) || ((countX > sizeX) && (x == (size2X - countX)));
        boolean activeY = (y == countY) || ((countY > sizeY) && (y == (size2Y - countY)));

        if (activeX && activeY) {
            return false;
        } else {
            return activeX || activeY;
        }
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
