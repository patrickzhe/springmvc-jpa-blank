package com.example.mvc;

import com.example.mvc.entity.Address;
import com.example.mvc.entity.Person;
import com.example.mvc.repository.PersonRepository;
import org.junit.Before;

import javax.inject.Inject;
import java.util.Date;
import java.util.Random;

/**
 * Created by hzchenzhe1 on 2016/5/17.
 */
public class BaseTest {
    @Inject
    protected PersonRepository personRepository;
    private static final String[] LAST_NAMES = {"STEPHEN", "JOE", "MICKLE", "KOBE", "TIM", "DERK", "KALLY", "", "BEAST", "CJ"};
    private static final String[] FIRST_NAMES = {"ALLAN", "JOHNSON", "BEN", "JASON", "WADE", "JORDAN", "CURRY", "JAMES", "GREEN", "MILES"};
    private static final String[] ADDRESSS = {"WANGSHANGLU 599","BINANLU 111","JIANGNANDADAO 11","BINKANGLU 213","JIANGHUILU 123", "WANGJIANGLU 223", };
    protected Person testPerson = null;
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
}
