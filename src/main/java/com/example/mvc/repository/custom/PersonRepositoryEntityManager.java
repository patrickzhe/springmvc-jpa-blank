package com.example.mvc.repository.custom;

import com.example.mvc.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by hzchenzhe1 on 2016/5/17.
 */
@Component
public class PersonRepositoryEntityManager {

    @PersistenceContext
    EntityManager entityManager;

    public Collection<Person> findByFirstName(String name) {
        Query queryEmployeesByFirstName = entityManager.createNamedQuery("Person.findByFirstName");
        queryEmployeesByFirstName.setParameter(1, name);
        Collection employees = queryEmployeesByFirstName.getResultList();
        return employees;
    }

}
