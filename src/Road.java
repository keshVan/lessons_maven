public class Road {
    City finalCity;
    int cost;

    public Road(City finalCity, int cost) {
        this.finalCity = finalCity;
        this.cost = cost;
    }

    public String toString() {
        return finalCity.name + ": " + cost;
    }
}
