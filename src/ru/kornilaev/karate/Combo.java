package ru.kornilaev.karate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combo implements Action {
    String name;
    List<Action> actions = new ArrayList<>();

    public Combo(Action... actions) {
        this.actions.addAll(Arrays.asList(actions));
    }

    public void make(KarateKid kid) {
        for (Action action : actions)
            action.make(kid);
    }

}
