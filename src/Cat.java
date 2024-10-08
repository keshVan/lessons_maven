import javax.security.auth.login.AccountNotFoundException;

public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public String toString() {
        return "кот: " + name;
    }

    public void meow(){
        meow(0);
    }

    public void meow(int count) {
        String out = name + ": ";

        for (int i = 0; i < count-1; i++)
            out += "мяу-";

        out += "мяу!";

        System.out.println(out);
    }
}
