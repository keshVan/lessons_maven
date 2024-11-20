package ru.kornilaev.karate;

public class JumpKick implements Hittable {

    @Override
    public void hit(String executor) {
        System.out.println(executor + ": вжух!");
    }
}
