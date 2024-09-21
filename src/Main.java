import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(arr.toString());

        arr.add(31, 2);
        System.out.println(arr.toString());


        Dot dot1 = new Dot();
        dot1.x = 3.1;
        dot1.y = 1.7;

        Dot dot2 = new Dot();
        dot2.x = 2.8;
        dot2.y = 1;

        Dot dot3 = new Dot();
        dot3.x = -5;
        dot3.y = 9.21;

        System.out.println(dot1.toString());
        System.out.println(dot2.toString());
        System.out.println(dot3.toString());

        Human hm1 = new Human();
        Human hm2 = new Human();
        Human hm3 = new Human();

        hm1.name = "Клеопатра";
        hm1.height = 152;

        hm2.name = "Пушкин";
        hm2.height = 167;

        hm3.name = "Владимир";
        hm3.height = 189;

        System.out.println(hm1.toString());
        System.out.println(hm2.toString());
        System.out.println(hm3.toString());

        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();

        name1.firstName = "Клеопатра";
        name2.lastName = "Пушкин";
        name2.firstName = "Александр";
        name2.patronymic = "Сергеевич";
        name3.lastName = "Маяковский";
        name3.firstName = "Владимир";

        System.out.println(name1.toString());
        System.out.println(name2.toString());
        System.out.println(name3.toString());

        Time time1 =  new Time();
        Time time2 =  new Time();
        Time time3 =  new Time();

        time1.seconds = 10;
        time2.seconds = 10000;
        time3.seconds = 100000;

        System.out.println(time1.toString());
        System.out.println(time2.toString());
        System.out.println(time3.toString());

        House house1 = new House();
        House house2 = new House();
        House house3 = new House();

        house1.floors = 1;
        house2.floors = 5;
        house3.floors = 23;

        System.out.println(house1.toString());
        System.out.println(house2.toString());
        System.out.println(house3.toString());
    }
}