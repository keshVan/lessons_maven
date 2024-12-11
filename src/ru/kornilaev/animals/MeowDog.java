package ru.kornilaev.animals;

public class MeowDog implements Meowable {
    Dog dog;

    public MeowDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void meow() {
        dog.bark();
    }
}
