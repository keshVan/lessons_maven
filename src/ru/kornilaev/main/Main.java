package ru.kornilaev.main;

import ru.kornilaev.animals.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("барсик");
        Dog dog = new Dog("крут");
        MeowDog md = new MeowDog(dog);
        MeowCount mw = new MeowCount(md);
        test(mw);
        System.out.println(mw.count);
    }
    public static void test(Meowable m) {
        m.meow();
        m.meow();
        m.meow();
        m.meow();
        m.meow();
    }
}







