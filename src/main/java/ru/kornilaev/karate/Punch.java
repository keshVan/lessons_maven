package ru.kornilaev.karate;

public class Punch implements Action {

    @Override
    public void make(KarateKid kid) {
        kid.punch();
    }
}
