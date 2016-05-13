package com.example.mvc.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import com.example.mvc.entity.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Person;

import java.util.Date;
import java.util.List;
import java.util.Random;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonRepositoryTest {
    @Inject
    PersonRepository personRepository;

    private static final String[] LAST_NAMES = {"STEPHEN", "JOE", "MICKLE", "KOBE", "TIM", "DERK", "KALLY", "", "BEAST", "CJ"};
    private static final String[] FIRST_NAMES = {"ALLAN", "JOHNSON", "BEN", "JASON", "WADE", "JORDAN", "CURRY", "JAMES", "GREEN", "MILES"};
    private static final String[] ADDRESSS = {"WANGSHANGLU 599","BINANLU 111","JIANGNANDADAO 11","BINKANGLU 213","JIANGHUILU 123", "WANGJIANGLU 223", };

    private Person testPerson = null;
    @Before
    public void setUp() {
        personRepository.deleteAll();
        for (int i = 1; i <= 20; i++) {
            Person p = new Person();
            p.setAge(i % 100);
            p.setName("name" + i);
            p.setFirstName(FIRST_NAMES[new Random().nextInt(FIRST_NAMES.length)]);
            p.setLastName(LAST_NAMES[new Random().nextInt(LAST_NAMES.length)]);
            p.setCreationTime(new Date());
            p.setModificationTime(new Date());
            Address address = new Address();
            address.setCity("Hangzhou");
            address.setZipCode("310000");
            address.setCity("China");
            address.setProvince("Zhejiang");
            address.setAddress(ADDRESSS[new Random().nextInt(ADDRESSS.length)]);
            p.setAddress(address);
            if (i == 1 ) testPerson = p;
            personRepository.save(p);
        }
        personRepository.flush();
    }

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


}
