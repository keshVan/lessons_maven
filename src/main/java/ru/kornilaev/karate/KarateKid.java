package ru.kornilaev.karate;

public class KarateKid {
    final String name;
    public KarateKid(String name) {
        this.name = name;
    }

    public void kick() {
        System.out.println(name + ": бац!");
    }

    public void punch() {
        System.out.println(name + ": кия!");
    }

    public void jumpKick() {
        System.out.println(name + ": вжух!");
    }

}
