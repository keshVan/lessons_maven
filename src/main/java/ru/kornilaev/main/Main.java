package ru.kornilaev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kornilaev.dao.DAO;
import ru.kornilaev.dao.Employee;

import java.sql.SQLException;
import java.util.List;


class Main {
    public static void main(String[] args) throws SQLException, NoSuchMethodException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru/kornilaev/dao", "ru/kornilaev/post_processors");
        DAO dao = ctx.getBean(DAO.class);
        List<Employee> employees = dao.findAll(Employee.class);
        System.out.println(employees);

    }
}



