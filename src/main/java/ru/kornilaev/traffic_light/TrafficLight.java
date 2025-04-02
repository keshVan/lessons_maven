package ru.kornilaev.traffic_light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrafficLight {
    State state;

    public TrafficLight(@Qualifier("red") State state) {
        this.state = state;
    }

    public void next() {
        System.out.println(state.getColor());
        state = state.next();
    }
}
