package com.example.mvc.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import com.example.mvc.BaseTest;
import com.example.mvc.entity.Address;
import com.example.mvc.repository.custom.PersonRepositoryEntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Person;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonRepositoryTest extends BaseTest {


    @Autowired PersonRepositoryEntityManager personRepositoryEntityManager;

    @Test
    public void testCount() {
        assertEquals(20, personRepository.count());
    }

    @Test
    public void testFindByName() {
        Page<Person> p = personRepository.findByNameLike("%name1%", new PageRequest(
                0, 5));
        System.out.println(p.getContent());
        assertNotNull(p);
        assertEquals(5, p.getNumberOfElements());
        assertEquals(0, p.getNumber());
        assertEquals(5, p.getSize());
        assertEquals(3, p.getTotalPages());
        assertEquals(11, p.getTotalElements());
    }

    @Test
    public void testGetByLastNameAndFistName() {
        List p = personRepository.getByLastNameAndFirstName(testPerson.getLastName(), testPerson.getFirstName());
        System.out.println(p.size());
    }

    @Test
    public void testFindByFirstName() {
        Collection<Person> persons = personRepositoryEntityManager.findByFirstName(testPerson.getFirstName());
        assertTrue(persons.size() > 0);
    }

    @Test
    public void testFindFirstByOrderByFirstNameAsc() {
        Person persons = personRepository.findFirstByOrderByFirstNameAsc();
        assertNotNull(persons);
        System.out.println(persons);
    }

    @Test
    public void testAsync() {
        Future<List<Person>> persons = personRepository.findByFirstName(testPerson.getFirstName());
        System.out.println("+++++++++++++++++++");
        try {
            persons.get();
            assertNotNull(persons);
            System.out.println(persons);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
