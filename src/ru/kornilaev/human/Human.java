package ru.kornilaev.human;

public class Human {
    private Name name;
    private int height;
    private int age;
    private Human father;

    public Human(String name, int height, int age) {
        this(name, height, null, age);
    }

    public Human(String name, int height, Human father, int age) {
        this(new Name(name), height, father, age);
    }

    public Human(Name name, int height, int age) {
        this(name, height, null, age);
    }

    public Human(Name name, int height, Human father, int age) {
        this.name = name;
        if (father != null) {
            if(name.getLastName() == null && father.name.getLastName() != null) name.setLastName(father.name.getLastName());
            if(name.getPatronymic() == null)  name.setPatronymic(formatPatronymic(father.name.getFirstName()));
        }
        this.height = height;
        this.age = age;
    }

    /*public Human(Human h) {
        this(h.name, h.height, h.father.getHeight());
    }*/

    public Name getName() {
        return new Name(name);
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    /*public Human getFather() {
        return new Human(father);
    }*/

    public void setFather(Human father) {
        this.father = father;
    }
    
    private String formatPatronymic(String name) {
        if (name == "Лев") return "Львович";
        if (name.charAt(name.length()-1) == 'й') return name.substring(0, name.length()-1) + "евич";
        return name + "ович";
    }

    public String toString() {
        return name + ", рост: " + height;
    }

}
