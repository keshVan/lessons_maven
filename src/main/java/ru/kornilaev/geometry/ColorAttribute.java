package ru.kornilaev.geometry;

import ru.kornilaev.points.Attribute;

public class ColorAttribute extends Attribute {
    public ColorAttribute(String value) {
        super("Color", value);
    }

    @Override
    public String getValue() {
        return (String)super.getValue();
    }

    @Override
    public String toString() {
        return "цвет: " + getValue();
    }
}
