package ru.kornilaev.human;

import ru.kornilaev.handlers.ValidateException;

public class HumanTests {
    void test1(Human h) {
        if (h.getHeight() < 50 || h.getHeight() > 250)
            throw new ValidateException("ошибка в test1: рост человека должен быть в диапазоне от 50 до 250");
    }

    void test2(Human h) {
        if (h.getAge() < 1 && h.getAge() > 200)
            throw new ValidateException("ошибка в test2: возраст человека не в диапазоне от 1 до 200");
    }
}
