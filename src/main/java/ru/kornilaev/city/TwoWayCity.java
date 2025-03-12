package ru.kornilaev.city;

public class TwoWayCity extends City {
    public TwoWayCity(String name, Road... roads) {
        super(name, roads);
    }

    public void putRoad(Road newRoad) {
        super.putRoad(newRoad);
        for (Road road : newRoad.getDestinationCity().getRoads())
            if (road.getDestinationCity() == this && road.getCost() == newRoad.getCost()) return;
        newRoad.getDestinationCity().putRoad(this, newRoad.getCost());
    }
}
