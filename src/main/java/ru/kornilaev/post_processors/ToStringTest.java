package ru.kornilaev.post_processors;

import org.springframework.stereotype.Component;
import ru.kornilaev.reflection.ToString;

@Component
@ToString
public class ToStringTest {
    public int x = 5;
    public String y = "nice";
}
