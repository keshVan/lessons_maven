public class House {
    public int floors;

    public String toString() {
        if (floors % 10 == 1 && floors % 100 != 11) {
            return "Дом с " + floors + " этажом";
        }
        else{
            return  "Дом с " + floors + " этажами";
        }
    }
}
