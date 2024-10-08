import java.rmi.StubNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(3, 5);
        Point point2 = new Point(25, 6);
        Point point3 = new Point(7, 8);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println();

        Line line1 =  new Line(new Point(1,3), new Point(23,8));
        Line line2 = new Line(5, 10, 25, 10);
        Line line3 = new Line(line1.start, line2.end);

        House house1 = new House(2);
        House house2 = new House(35);
        House house3 = new House(91);
        //house1.floors = 5;
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
        System.out.println();

        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Пушкин", "Сергеевич");
        Name name3 = new Name("Владимир", "Маяковский");
        Name name4 = new Name("Христофор", "Бонифатьевич");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println();

        Human human1 = new Human("Лев", 170);
        Human human2 = new Human(new Name("Сергей", "Пушкин"), 168, human1);
        Human human3 = new Human("Александр", 167, human2);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println();

        Student student1 = new Student("Вася", 3, 4, 5);
        Student student2 = new Student("Максим");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println();

        Gun gun = new Gun(3);
        gun.shoot();
        gun.shoot();
        gun.shoot();
        gun.shoot();
        gun.shoot();
        System.out.println();

        Cat cat = new Cat("Барсик");
        cat.meow();
        cat.meow(3);
        System.out.println();

        Line line4 =  new Line(1, 1, 10, 15);
        System.out.println(line4.getLength());
        System.out.println();

        Time time1 = new Time(34056);
        Time time2 = new Time(4532);
        Time time3 = new Time(123);

        System.out.println(time1.getHour());
        System.out.println(time2.getMinute());
        System.out.println(time3.getSeconds());

        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(1, 8);

        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.mult(f2));
        System.out.println(f1 + " : " + f2 + " = " + f1.div(f2));

        System.out.println(f1.sum(f2).div(f3).minus(5));
        System.out.println();

        Student student3 = new Student("Вася", 3, 4, 5, 4);
        Student student4 = new Student("Петя", 5, 5, 5, 5);
        System.out.println(student3.getAverageMarks());
        System.out.println(student4.getAverageMarks());
        System.out.println(student3.isExcellentStudent());
        System.out.println(student4.isExcellentStudent());
        System.out.println();

        BrokenLine bline1 = new BrokenLine(new Point(1, 5), new Point(2, 8), new Point(5, 3));
        System.out.println(bline1.getLength());
        bline1.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println(bline1.getLength());
        System.out.println();

        Square square = new Square(5, 3, 23);
        BrokenLine bline2 = square.getBrokenLine();
        System.out.println(bline2.getLength());
        bline2.points[bline2.points.length-1].x = 15;
        bline2.points[bline2.points.length-1].y = 25;
        System.out.println(bline2.getLength());

    }
}