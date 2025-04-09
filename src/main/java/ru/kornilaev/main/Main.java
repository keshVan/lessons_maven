package ru.kornilaev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru/kornilaev/post_processors");
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
        System.out.println(ctx.getBean("random"));
    }
}



