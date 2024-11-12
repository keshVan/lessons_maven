package ru.kornilaev.animals;

public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        checkName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be null or empty");
    }

    public String toString() {
        return "кот: " + name;
    }

    public void meow(){
        meow(0);
    }

    public void meow(int count) {
        String out = name + ": ";

        for (int i = 0; i < count-1; i++)
            out += "мяу-";

        out += "мяу!";

        System.out.println(out);
    }
}
