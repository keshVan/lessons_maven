package ru.kornilaev.animals;

public class MeowAttention implements Meowable {
    Meowable m;

    public MeowAttention(Meowable m) {
        this.m = m;
    }

    @Override
    public void meow() {
        System.out.print("Внимание! ");
        m.meow();
    }
}
