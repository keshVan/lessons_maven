import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    List<Road> roads = new ArrayList<Road>();

    public City(String name) {
        this.name = name;
    }

    public City(String name, City[] cities, int[] prices){
        this(name);
        for (int i = 0; i < cities.length; i++) {
            this.addLinkedCity(cities[i], prices[i]);
        }
    }

    public void addLinkedCity(City linkedCity, int price) {
        roads.add(new Road(linkedCity, price));
    }

    public String toString() {
        return "Из города " + name + " можно поехать в " + roads;
    }
}
