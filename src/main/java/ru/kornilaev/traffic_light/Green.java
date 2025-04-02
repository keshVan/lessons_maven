package ru.kornilaev.traffic_light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Green implements State {
    final String color = "Зеленый";
    State nextState;

    @Autowired
    public void setNextState(@Qualifier("yellowGreen") State nextState) {
        this.nextState = nextState;
    }

    @Override
    public State next() {
        return nextState;
    }

    @Override
    public String getColor() {
        return color;
    }
}
