package ru.kornilaev.karate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combo {
    List<Hittable> listTechniques = new ArrayList<>();

    public Combo(Hittable... techniques) {
        this.listTechniques.addAll(Arrays.asList(techniques));
    }

    public void addTechniques(Hittable attack) {
        listTechniques.add(attack);
    }

    public void addTechniques(Hittable attack, int index) {
        listTechniques.add(index, attack);
    }

    public void removeTechniques(Hittable attack) {
        listTechniques.remove(attack);
    }

    public void removeTechniques(int index) {
        listTechniques.remove(index);
    }

    public void removeLastTechniques() {
        removeTechniques(listTechniques.size() - 1);
    }

}
