package ru.kornilaev.dao;

import lombok.ToString;

@ToString
public class Employee {
    Integer id;
    String name;
    Integer depId;

    public Employee(@FieldName("id")    Integer id,
                    @FieldName("name")  String name,
                    @FieldName("depId") Integer depId) {
        this.id = id;
        this.name = name;
        this.depId = depId;
    }
    
}
