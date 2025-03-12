package ru.kornilaev.traffic_light;

public class Green implements State {
    final String color = "Зеленый";

    @Override
    public void next(TrafficLight tf) {
        tf.changeState(new Yellow(this));
    }

    @Override
    public String getColor() {
        return color;
    }
}
