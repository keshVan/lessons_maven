package ru.kornilaev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kornilaev.streamer.DoubleOperator;
import ru.kornilaev.streamer.FileSourceTarget;
import ru.kornilaev.streamer.Streamer;
import ru.kornilaev.streamer.ToUpperOperator;
import ru.kornilaev.student.StudentFactory;
import ru.kornilaev.traffic_light.TrafficLight;

import java.util.List;

class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru/kornilaev/traffic_light", "ru/kornilaev/streamer");
        /*FileSourceTarget fst = ctx.getBean(FileSourceTarget.class);
        fst.setSource("src/main/resources/test.txt");
        fst.setTarget("src/main/resources/out.txt");
        Streamer streamer = ctx.getBean(Streamer.class);
        streamer.setActions(List.of(ctx.getBean(ToUpperOperator.class), ctx.getBean(DoubleOperator.class)));
        streamer.execute();*/

        TrafficLight tf = ctx.getBean(TrafficLight.class);
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();

    }
}



