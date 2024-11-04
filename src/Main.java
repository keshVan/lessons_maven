public class Main {
    public static void main(String[] args) {
        Point1D p1 = new Point1D(3, new ColorAttribute("красный"));
        Point3D p2 = new Point3D(4, 2, 5, new TimeAttribute("11:00"));
        Point2D p3 = new Point2D(7, 7, new TimeAttribute("15:35"), new ColorAttribute("желтый"));

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}