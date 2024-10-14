import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        City city1 = new City("Saratov");
        City city2 = new City("Samara");

        city1.addRoad(city2, 5);
        city1.getRoads().add(new Road(city2,  5));

        System.out.println(city1);




    }
}