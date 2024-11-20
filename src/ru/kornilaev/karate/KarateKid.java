package ru.kornilaev.karate;

public class KarateKid {
    final String name;
    Combo combo;

    public KarateKid(String name, Combo combo) {
        this.name = name;
        this.combo = combo;
    }

    public KarateKid(String name) {
        this(name, null);
    }


    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public void performCombo() {
        if (combo == null) {
            System.out.println(name + ": ничего не умеет.");
            return;
        }
        for (Hittable techniques : combo.listTechniques)
            techniques.hit(name);
    }

}
