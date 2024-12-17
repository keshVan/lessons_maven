package ru.kornilaev.traffic_light;

public interface State {
    void next(TrafficLight tf);
    String getColor();
}
