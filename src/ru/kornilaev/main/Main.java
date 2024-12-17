package ru.kornilaev.main;

import ru.kornilaev.traffic_light.*;

class Main {
    public static void main(String[] args) {
        TrafficLight tf = new TrafficLight(new Red());
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
    }
}
