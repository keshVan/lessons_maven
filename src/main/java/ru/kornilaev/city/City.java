package ru.kornilaev.city;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private List<Road> roads = new ArrayList<Road>();

    public City(String name, Road... roads){
        for (Road road : roads) {
            putRoad(road);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Road> getRoads() {
        return new ArrayList<>(roads);
    }

    public void setRoads(List<Road> roads) {
        this.roads = new ArrayList<Road>();
        for (Road road : roads){
            putRoad(road);
        }
    }

    public void putRoad(City destinationCity, int price) {
        putRoad(new Road(destinationCity, price));
    }

    public void putRoad(Road newRoad) {
        if(newRoad.getDestinationCity() == this)
            throw new IllegalArgumentException("ru.kornilaev.city.Road from " + name + " to " + newRoad.getDestinationCity().getName() + " cannot exist");

        for (Road road : roads) {
            if (road.getDestinationCity() == newRoad.getDestinationCity()){
                road.setCost(newRoad.getCost());
                System.out.println(name + " " + newRoad.getDestinationCity().name);
                return;
            }
        }
        roads.add(newRoad);
    }

    public String toString() {
        return "Из города " + name + " можно поехать в " + roads;
    }

    public void deleteRoad(City city){
        if (!deleteRoadTo(city))
            throw new IllegalArgumentException("ru.kornilaev.city.Road from " + name + " to " + city.getName() + " doesn't exist");
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof City)) return false;
        City city = (City) o;
        if (roads.size() != city.roads.size()) return false;
        if (!roads.containsAll(city.roads)) return  false;

        /*int count = 0;
        for (Road curRoad : roads) {
            for (Road road : city.roads) {
                if (curRoad.equals(road)) {
                    count++;
                    break;
                }
            }
        }*/

        return true;


    }

    @Override
    public final int hashCode() {
        int roadHash = 0;
        for (Road road : roads)
            roadHash += Objects.hashCode(road);
        return roadHash;
    }

    private boolean deleteRoadTo(City destCity){
        for (Road road : roads){
            if (road.getDestinationCity() == destCity){
                roads.remove(road);
                return true;
            }
        }
        return false;
    }

}
