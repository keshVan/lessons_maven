package ru.kornilaev.traffic_light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*@Component
public class Green implements State {
    private final String color = "Зеленый";
    private final State nextState;

    @Autowired
    public Green(State nextState) {
        this.nextState = nextState;
    }

    @Override
    public void next(TrafficLight tf) {
        tf.changeState(new Yellow(this));
    }

    @Override
    public String getColor() {
        return color;
    }
}*/
