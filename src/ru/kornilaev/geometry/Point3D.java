package ru.kornilaev.geometry;

import java.util.List;
import java.util.Objects;

public class Point3D extends Point {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point = (Point3D) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public Point3D clone(){
        Point3D p = (Point3D) super.clone();
        p.z = z;
        return p;
    }

    @Override
    public List<Integer> getCoords() {
        List<Integer> res = super.getCoords();
        res.add(z);
        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
