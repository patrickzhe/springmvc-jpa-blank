package com.example.mvc.service.impl;

import com.example.mvc.specs.PersonPredicatesBuilder;
import com.example.mvc.specs.PersonSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Person;
import com.example.mvc.repository.PersonRepository;
import com.example.mvc.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    protected PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Person> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "id"));
        Page<Person> persons = personRepository.findAll(pageable);
        return persons;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Person> findByNameLike(String name, int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "id"));
        String q = "%" + name + "%";
        Page<Person> persons = personRepository.findByNameLike(q, pageable);
        return persons;
    }

    @Override
    @Transactional(readOnly = true)
    public Person findById(long id) {
        Person person = personRepository.findOne(id);
        return person;
    }


    @Override
    @Transactional
    public Person insert(Person person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        personRepository.delete(id);
    }

    @Override public List<Person> findUnderAgeFirstNamePerson(int age, String firstName) {
        return personRepository.findAll(PersonSpecs.isUnderAgeAndFirstNameLike(age, firstName));
    }

    @Override public List<Person> findUnderAgeFirstNamePersonByBuilder(int age, String firstName) {
        PersonPredicatesBuilder builder = new PersonPredicatesBuilder().with("age", "<=", age).with("firstName", ":", firstName);

//        Iterable<Person> ps = personRepository.findAll(builder.build());
        return null;
    }

}
