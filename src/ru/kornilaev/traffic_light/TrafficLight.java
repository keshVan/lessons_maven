package ru.kornilaev.traffic_light;

public class TrafficLight {
    State state;

    public TrafficLight(State state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
        System.out.println(state.getColor());
    }

    public void changeState(State state) {
        this.state = state;
    }
}
