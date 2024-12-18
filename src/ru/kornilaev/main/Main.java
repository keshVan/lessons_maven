package ru.kornilaev.main;

import ru.kornilaev.stocks.*;

class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Bot bot = new Bot(70);

        Stock orcl = new Stock("ORCL", 75);
        Stock tsla = new Stock("TSLA", 696);

        orcl.addObserver(printer);
        orcl.addObserver(bot);
        tsla.addObserver(printer);


        tsla.setPrice(700);
        tsla.setPrice(701);
        orcl.setPrice(81);
        tsla.setPrice(703);
        orcl.setPrice(73);
        orcl.setPrice(69);
        orcl.setPrice(68);
        orcl.setPrice(67);
    }
}
