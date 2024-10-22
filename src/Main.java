import javax.swing.*;
import java.util.EnumMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Secret secret1 = new Secret("Меня зовут Вито Скалетта. Я родился на Сицилии, в 25-м году. На дворе стоял 43-й год. Шла война. Высадка на Сицилии, нужны были солдаты говорящие на итальянском. Мне было 18, и в тюрьму я не хотел. Кто сказал, что нельзя вернуться на Родину?", "Вито");
        Secret secret2 = new Secret(secret1, "Джо");
        Secret secret3 = new Secret(secret2, "дженкинс");
    }
}