import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException("Road from " + name + " to " + newRoad.getDestinationCity().getName() + " cannot exist");

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
            throw new IllegalArgumentException("Road from " + name + " to " + city.getName() + " doesn't exist");
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
