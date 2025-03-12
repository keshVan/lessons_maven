package ru.kornilaev.traffic_light;

public class Red implements State {
    final String color = "Красный";

    @Override
    public void next(TrafficLight tf) {
        tf.changeState(new Yellow(this));
    }

    @Override
    public String getColor() {
        return color;
    }
}
