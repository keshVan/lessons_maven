package ru.kornilaev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kornilaev.streamer.DoubleOperator;
import ru.kornilaev.streamer.FileSourceTarget;
import ru.kornilaev.streamer.Streamer;
import ru.kornilaev.streamer.ToUpperOperator;
import ru.kornilaev.student.StudentFactory;

import java.util.List;

class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru/kornilaev/spring", "ru/kornilaev/student", "ru/kornilaev/streamer");
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("bestFeedback"));

        StudentFactory sf = ctx.getBean(StudentFactory.class);
        System.out.println(sf.newStudent("женя", 2, 5, 5, 5, 5));

        /*FileSourceTarget fst = ctx.getBean(FileSourceTarget.class);
        fst.setSource("src/main/resources/test.txt");
        fst.setTarget("src/main/resources/out.txt");
        Streamer streamer = ctx.getBean(Streamer.class);
        streamer.setActions(List.of(ctx.getBean(ToUpperOperator.class), ctx.getBean(DoubleOperator.class)));
        streamer.execute();*/

    }
}



