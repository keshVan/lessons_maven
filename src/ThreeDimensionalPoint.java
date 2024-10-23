public class ThreeDimensionalPoint extends Point {
    int z;

    public ThreeDimensionalPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}
