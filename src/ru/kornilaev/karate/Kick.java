package ru.kornilaev.karate;

public class Kick implements Hittable {

    @Override
    public void hit(String executor) {
        System.out.println(executor + ": бац!");
    }
}
