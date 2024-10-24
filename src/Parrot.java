import java.util.Random;

public class Parrot extends Bird {
    public Parrot(String text) {
        super(text);
    }

    public void sing() {
        Random r = new Random();
        String text = getText();
        System.out.println(text.substring(0, r.nextInt(text.length()) + 1));
    }
}
