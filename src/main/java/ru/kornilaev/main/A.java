package ru.kornilaev.main;

import ru.kornilaev.reflection.Cache;

@Cache({"m3"})
class A implements TestCache {
    public int x = 55;
    @Override
    public int m3() {
        System.out.println("original m3 zero args");
        return x;
    }

    @Override
    public int m3(int a, int b) {
        System.out.println("original m3 two args");
        return a + b;
    }

    @Override
    public int m4() {
        System.out.println("original m4 zero args");
        return 0;
    }
}