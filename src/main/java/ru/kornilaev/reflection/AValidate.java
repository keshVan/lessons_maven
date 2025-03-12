package ru.kornilaev.reflection;

import ru.kornilaev.human.HumanTests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Validate({HumanTests.class})
public @interface AValidate {
}
