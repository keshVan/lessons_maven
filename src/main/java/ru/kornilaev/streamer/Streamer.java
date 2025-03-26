package ru.kornilaev.streamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.UnaryOperator;

@Component
public class Streamer {
    private DataSourceTarget dst;
    private List<Action> actions;

    @Autowired
    public Streamer(DataSourceTarget dst) {
        this.dst = dst;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void execute() {
        List<String> data = dst.read();
        for (Action a : actions) {
            data = a.apply(data);
        }
        dst.write(data);
    }
}
