import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    List<Road> roads = new ArrayList<Road>();

    public City(String name) {
        this.name = name;
    }

    public void addLinkedCity(City linkedCity, int cost) {
        roads.add(new Road(linkedCity, cost));
    }

    public String toString() {
        String out = "Из города " + name + " можно поехать в ";

        for (int i = 0; i < roads.size()-1; i++)
            out += roads.get(i) + ", ";

        out += roads.get(roads.size()-1);

        return out;
    }
}
