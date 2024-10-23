public class Main {
    public static void main(String[] args) {
        Rifle rifle = new Rifle(50, 5);
        rifle.shootNthSecs(3);

        Fraction f = new Fraction(25, 4);
        System.out.println(f.intValue());
        System.out.println(f.longValue());
        System.out.println(f.floatValue());
        System.out.println(f.doubleValue());

        Sparrow spr = new Sparrow();
        spr.sing();
        Cuckoo ck = new Cuckoo();
        ck.sing();
        Parrot pr = new Parrot("Меня зовут Вито Скалетто. Я родился на Сицилии в 25 году");
        pr.sing();
    }
}