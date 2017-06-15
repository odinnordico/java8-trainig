package com.globant.corp.trainig.annotation.repeating;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
@Repeatable(Attributes.class)
public @interface Attribute {
    int age() default 0;
    String firstName() default "fName";
    String lastName() default "lName";

}
