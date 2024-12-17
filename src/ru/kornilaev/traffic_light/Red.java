package ru.kornilaev.traffic_light;

public class Red implements State {

    @Override
    public void next(TrafficLight tf) {
        tf.changeState(new Yellow(this));
    }

    @Override
    public String getColor() {
        return "Красный";
    }
}
