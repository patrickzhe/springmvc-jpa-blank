package com.example.mvc.service;

import org.springframework.data.domain.Page;

import com.example.mvc.entity.Person;

import java.util.List;

public interface PersonService {
    Page<Person> findAll(int page, int size);

    Page<Person> findByNameLike(String name, int page, int size);

    Person findById(long id);

    Person insert(Person person);

    Person update(Person person);

    void deleteById(long id);

    List<Person> findUnderAgeFirstNamePerson(int age, String firstName);

    List<Person> findUnderAgeFirstNamePersonByBuilder(int age, String firstName);
}
