package ru.kornilaev.karate;

public class Kick implements Action {
    @Override
    public void make(KarateKid kid) {
        kid.kick();
    }
}

