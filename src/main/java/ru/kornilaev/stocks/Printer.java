package ru.kornilaev.stocks;


public class Printer implements StockObserver {
    public void update(Stock s) {
        System.out.println(s.getName() + ": new price = " + s.getPrice());
    }
}
