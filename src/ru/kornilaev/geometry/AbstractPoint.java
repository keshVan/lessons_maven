package ru.kornilaev.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractPoint {
    protected int[] coordinates;
    protected List<Attribute> attributes;

    public AbstractPoint(int dimensions, Attribute... attributes) {
        coordinates = new int[dimensions];
        this.attributes = Arrays.asList(attributes);
    }

    public int[] getCoordinates() {
        return Arrays.copyOf(coordinates, coordinates.length);
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public List<Attribute> getAttributes() {
        return new ArrayList<>(attributes);
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Точка в координате {");
        for (int i = 0; i < coordinates.length - 1; i++) {
            out.append(coordinates[i]);
            out.append(",");
        }
        out.append(coordinates[coordinates.length - 1]);
        out.append("} ");

        for (int i = 0; i < attributes.size() - 1; i++) {
            out.append(attributes.get(i));
            out.append(", ");
        }
        out.append(attributes.getLast());


        return out.toString();
    }
}
