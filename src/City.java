import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Road> roads = new ArrayList<Road>();

    public City(String name) {
        this.name = name;
    }

    public City(String name, City[] cities, int[] prices){
        this(name);
        for (int i = 0; i < cities.length; i++) {
            this.addRoad(cities[i], prices[i]);
        }
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
        this.roads = roads;
    }

    public void addRoad(City destinationCity, int price) {
        addRoad(new Road(destinationCity, price));
    }

    public void addRoad(Road road) {
        if (!checkCity(road.getDestinationCity()))
            throw new IllegalArgumentException("Road already exists between " + name + " and " + road.getDestinationCity().getName());

        roads.add(road);
        road.getDestinationCity().roads.add(new Road(this, road.getCost()));
    }

    public void deleteRoad(City city){
        if ( !(removeByCity(this, city) && removeByCity(city, this)) )
            throw new IllegalArgumentException("Road from " + name + " to " + city.name + " does not exist");
    }

    public String toString() {
        return "Из города " + name + " можно поехать в " + roads;
    }

    private boolean checkCity(City city){
        for (Road road : roads)
            if (road.getDestinationCity().equals(city)) return false;
        return true;
    }

    private boolean removeByCity(City start, City dest){
        boolean remove = false;
        for (Road road : start.roads){
            if (road.getDestinationCity().equals(dest)){
                start.roads.remove(road);
                remove = true;
                break;
            }
        }
        return remove;
    }

}
