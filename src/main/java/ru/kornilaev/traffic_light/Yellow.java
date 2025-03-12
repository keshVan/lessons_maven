package ru.kornilaev.traffic_light;

public class Yellow implements State{
    final String color = "Желтый";
    State prev;

    public Yellow(State prev) {
        this.prev = prev;
    }

    @Override
    public void next(TrafficLight tf) {
        if (prev.getColor().equals("Красный"))
            tf.changeState(new Green());
        else
            tf.changeState(new Red());
    }

    @Override
    public String getColor() {
        return color;
    }
}
