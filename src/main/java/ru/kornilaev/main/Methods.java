package ru.kornilaev.main;

import ru.kornilaev.animals.*;
import ru.kornilaev.geometry.*;

public class Methods {
    public static double sum(Number... nums) {
        double res = 0;
        for (Number num : nums)
            res += num.doubleValue();
        return  res;
    }

    public static void birdsShop(Bird... birds) {
        for (Bird bird : birds)
            bird.sing();
    }

    public static double totalArea(Shape... shapes) {
        double res = 0;
        for (Shape shape : shapes)
            res += shape.area();
        return res;
    }

    public static void meows(Meowable... mwbs) {
        for (Meowable mws : mwbs)
            mws.meow();
    }

    public static double totalLength(Lengthable... cntb) {
        double res = 0;
        for (Lengthable cnt : cntb)
            res += cnt.length();
        return res;
    }

    public static BrokenLine getBrokenLine(Brokenable... brks) {
        BrokenLine resLine = new BrokenLine();
        for (Brokenable brk : brks)
            resLine.addPoints(brk.getBrokenLine().getPoints());
        return resLine;
    }
}
