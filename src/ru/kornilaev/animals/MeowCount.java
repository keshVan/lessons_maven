package ru.kornilaev.animals;

public class MeowCount implements Meowable {
    Meowable m;
    public int count = 0;

    public MeowCount(Meowable m) {
        this.m = m;
    }

    @Override
    public void meow() {
        count++;
        m.meow();
    }

}
