package ru.kornilaev.points;

public abstract class Attribute {
    protected String name;
    protected Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
