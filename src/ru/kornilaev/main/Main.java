package ru.kornilaev.main;

import ru.kornilaev.karate.*;

public class Main {
    public static void main(String[] args) {
        KarateKid daniel = new KarateKid("Дэниэл");
        Combo combo = new Combo(new Punch(), new Kick(), new Punch(), new JumpKick());
        daniel.setCombo(combo);
        daniel.performCombo();
    }
}