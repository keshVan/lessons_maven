package ru.kornilaev.dao;

import lombok.ToString;

@ToString
public class Employee {
    @Column("id")
    Integer id;

    @Column("name")
    String name;

    @Column("dep_id")
    Integer depId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}
