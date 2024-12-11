package ru.kornilaev.animals;

public class DogCat extends Dog implements Meowable {
    private Cat cat;

    public DogCat(String name) {
        super(name);
        cat = new Cat(name);
    }

    @Override
    public void meow() {
        cat.meow();
    }
}
