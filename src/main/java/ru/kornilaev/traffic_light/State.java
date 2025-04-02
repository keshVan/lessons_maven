package ru.kornilaev.traffic_light;

public interface State {
    State next();
    String getColor();
}
