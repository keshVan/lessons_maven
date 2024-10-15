import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Road> roads = new ArrayList<Road>();

    public City(String name, Road... roads){
        for (Road road : roads) {
            addRoad(road);
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
            addRoad(road);
        }
    }

    public void addRoad(City destinationCity, int price) {
        addRoad(new Road(destinationCity, price));
    }

    public void addRoad(Road road) {
        if(road.getDestinationCity().equals(road))
            throw new IllegalArgumentException("Road from " + name + " to " + road.getDestinationCity().getName() + " cannot exist");

        checkCities(this, road.getDestinationCity());
        roads.add(road);
        road.getDestinationCity().addRoadBackTo(this, road.getCost());
    }

    public String toString() {
        return "Из города " + name + " можно поехать в " + roads;
    }

    private void addRoadBackTo(City city, int cost){
        roads.add(new Road(city, cost));
    }

    public void deleteRoad(City city){
        if ( !(deleteRoadTo(city) && city.deleteRoadTo(this)))
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

    private boolean checkCity(City city){
        for (Road road : roads)
            if (road.getDestinationCity() == city) return false;
        return true;
    }

    private void checkCities(City city1, City city2){
        if (!(city1.checkCity(city2) && city2.checkCity(city1)))
            throw new IllegalArgumentException("Road already exists between " + city1.getName() + " and " + city2.getName());
    }
}
