import java.util.Random;

public class Parrot extends Bird {
    private String text;

    public Parrot(String text) {
        super();
        this.text = text;
    }

    public void sing() {
        Random r = new Random();
        System.out.println(text.substring(0, r.nextInt(text.length()) + 1));
    }
}
