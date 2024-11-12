package ru.kornilaev.geometry;

public class TimeAttribute extends Attribute{
    public TimeAttribute(String value) {
        super("ru.kornilaev.time.Time", value);
    }

    @Override
    public String getValue() {
        return (String)super.getValue();
    }

    @Override
    public String toString() {
        return "в " + getValue();
    }
}
