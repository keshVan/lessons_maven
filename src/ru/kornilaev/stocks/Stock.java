package ru.kornilaev.stocks;

import java.util.ArrayList;
import java.util.List;



public class Stock {
    private final String name;
    private int price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        for (StockObserver o : observers)
            o.update(this);
    }

    public void addObserver(StockObserver o) {
        observers.add(o);
    }
}

