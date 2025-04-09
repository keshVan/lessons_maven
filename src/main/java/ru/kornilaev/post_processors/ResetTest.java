package ru.kornilaev.post_processors;


import org.springframework.stereotype.Component;
import ru.kornilaev.reflection.Default;

@Component
@Default("defaultReset")
public class ResetTest implements Resetable {
    public int age;
    public String str;

    @Override
    public void reset() {

    }
}
