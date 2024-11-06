import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum(2, new Fraction(3,5), 2.3));
        System.out.println(sum(3.6, new Fraction(49,12), 3, new Fraction(3,2)));
        System.out.println(sum(new Fraction(1, 3), 1));
        System.out.println("--------------------------------------------");

        birdsShop(new Sparrow(), new Cuckoo(), new Parrot("меня зовут Вито Скаллето"));
        System.out.println("--------------------------------------------");

        System.out.println(totalArea(new Circle(new Point(1, 1), 5), new Circle(new Point(5, 5), 7), new Square(new Point(7, 7), 3)));
        System.out.println("--------------------------------------------");

        meows(new Cat("пушок"), new Cat("чювачок"), new Tiger());
        System.out.println("--------------------------------------------");

        System.out.println(totalLength(new Line(1, 1, 2, 3), new Line(5, 1, 7, 1), new BrokenLine(new Point(1, 1), new Point(7, 3), new Point(2, 1))));
        System.out.println("--------------------------------------------");

        System.out.println(getBrokenLine(new Square(new Point(1, 1), 5), new Triangle(new Point(3, 4), new Point(5, 6), new Point(7, 8)), new Line(10, 11, 12, 13)));
        System.out.println("--------------------------------------------");

        Gunslinger bob = new Gunslinger("Боб");
        Gunslinger joe = new Gunslinger("Джо", new Gun());
        Gunslinger john = new Gunslinger("Боб", new Rifle());
        System.out.println("Стреляет Боб:");
        bob.shoot();
        System.out.println("--------------------------------------------");
        System.out.println("Стреляет Джо:");
        joe.shoot();
        System.out.println("--------------------------------------------");
        System.out.println("Стреляет Джон:");
        john.shoot();
        System.out.println("--------------------------------------------");

        TwoWayCity a =  new TwoWayCity("A");
        City b =  new City("B");
        City c =  new City("C");
        TwoWayCity d =  new TwoWayCity("D");
        City e = new City("E");
        a.putRoad(b, 1);
        a.putRoad(c, 1);
        b.putRoad(c, 1);
        d.putRoad(b, 1);
        d.putRoad(e, 1);
        e.putRoad(c, 1);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

    }

    public static void addMark(Student[] stds, int x) {
        for (Student s : stds) {
            try {
                s.addMark(x);
            }
            catch (IllegalMarkException e) {
                for (Student std : stds) {
                    if (std == s) return;
                    std.removeMark(std.getMarks().size() - 1);
                }
            }
        }
    }

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

    public static double totalLength(Countable... cntb) {
        double res = 0;
        for (Countable cnt : cntb)
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