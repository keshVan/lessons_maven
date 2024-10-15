public class Road {
    private final City destinationCity;
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
}
