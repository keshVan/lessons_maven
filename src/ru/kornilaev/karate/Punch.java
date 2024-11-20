package ru.kornilaev.karate;

public class Punch implements Hittable {

    @Override
    public void hit(String executor) {
        System.out.println(executor + ": кия!");
    }
}
