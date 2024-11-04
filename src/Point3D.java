public class Point3D extends AbstractPoint {
    private static final int DIMENSION = 3;
    private static final int INDEX_X = 0;
    private static final int INDEX_Y = 1;
    private static final int INDEX_Z = 2;

    public Point3D(int x, int y, int z, Attribute... attributes) {
        super(DIMENSION, attributes);
        coordinates[INDEX_X] = x;
        coordinates[INDEX_Y] = y;
        coordinates[INDEX_Z] = z;
    }

    public int getX() {
        return coordinates[INDEX_X];
    }

    public int getY() {
        return coordinates[INDEX_Y];
    }

    public int getZ() {
        return coordinates[INDEX_Z];
    }

    public void setX(int x) {
        coordinates[INDEX_X] = x;
    }

    public void setY(int y) {
        coordinates[INDEX_Y] = y;
    }

    public void setZ(int z) {
        coordinates[INDEX_Z] = z;
    }
}
