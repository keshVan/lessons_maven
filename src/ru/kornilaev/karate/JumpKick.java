package ru.kornilaev.karate;

public class JumpKick implements Action {

    @Override
    public void make(KarateKid kid) {
        kid.jumpKick();
    }
}
