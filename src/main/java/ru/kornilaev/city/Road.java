package ru.kornilaev.city;

import java.util.Objects;

public class Road {
    private City destinationCity;
    private int cost;

    public Road (City destinationCity, int cost) {
        this.destinationCity = destinationCity;
        this.cost = cost;
    }


    public City getDestinationCity() {
        return destinationCity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString() {
        return destinationCity.getName() + ": " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return  destinationCity == road.destinationCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationCity.getName());
    }
}
