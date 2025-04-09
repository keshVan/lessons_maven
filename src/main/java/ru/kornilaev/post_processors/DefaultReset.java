package ru.kornilaev.post_processors;

import org.springframework.stereotype.Component;

@Component
public class DefaultReset {
    int defaultAge() {
        return 18;
    }
    String defaultStr() {
        return "vasia";
    }
}
