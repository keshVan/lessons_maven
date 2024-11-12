package ru.kornilaev.house;

public class House {
    private final int floors;

    public House(int floors) {
        if (floors <= 0)
            throw new IllegalArgumentException("floors must be positive");
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public String toString() {
        if (floors % 10 == 1 && floors % 100 != 11) {
            return "Дом с " + floors + " этажом";
        }
        else {
            return  "Дом с " + floors + " этажами";
        }
    }
}
