package ru.kornilaev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kornilaev.spring.BeanConfig;
import ru.kornilaev.student.StudentFactory;

import java.util.Date;
import java.util.SortedMap;
import java.util.function.Predicate;

class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println(ctx.getBean("good"));
        System.out.println(ctx.getBean("veryGood"));
        System.out.println("1-----");
        System.out.println(ctx.getBean("bestFeedback"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println(ctx.getBean("hardToSay"));
        System.out.println("2-----");
        System.out.println(ctx.getBean("bestFeedback"));

        System.out.println(ctx.getBean("std1"));
        System.out.println(ctx.getBean("std2"));

        StudentFactory sf = ctx.getBean("sf", StudentFactory.class);
    }
}



