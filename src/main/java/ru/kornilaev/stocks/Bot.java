package ru.kornilaev.stocks;

public class Bot implements StockObserver {
    private int neededPrice;

    public Bot(int neededPrice) {
        this.neededPrice = neededPrice;
    }

    public void setNeededPrice(int neededPrice) {
        this.neededPrice = neededPrice;
    }

    @Override
    public void update(Stock s) {
        if (s.getPrice() < neededPrice)
            System.out.println("надо покупать " + s.getName());
    }
}
