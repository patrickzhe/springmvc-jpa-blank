package com.example.mvc.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * A  meta model class used to create type safe queries from person
 * information.
 * @author Petri Kainulainen
 */
@StaticMetamodel(Person.class)
public class Person_ {
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, Integer> age;
}
