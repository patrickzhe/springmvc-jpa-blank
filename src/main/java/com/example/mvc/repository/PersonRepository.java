package com.example.mvc.repository;

import com.example.mvc.entity.PersonInterface;
import com.example.mvc.repository.custom.PersonRepositoryCustom;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.mvc.entity.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person>,
                PersonRepositoryCustom, QueryDslPredicateExecutor<Person> {
    @Override
    Page<Person> findByNameLike(String name, Pageable pageable);

    //StartWith EndWith
    List<Person> findByFirstNameStartingWith(String firstNamePrefix);

    List<Person> findByLastNameEndingWith(String lastName);

    //after before (date)
    List<Person> findByCreationTimeBefore(Date date);

    //in
    List<Person> findByFirstNameIn(Collection<String> firstnames);

    List<Person> getByLastNameAndFirstName(String lastName, String firstName);

//    Long countByLastname(int age);

    // isNull NotNull
    List<Person> readAllByFirstNameNotNull();

    List<Person> findAllAddressIsNull();

    //And or
    List<Person> findByLastNameOrLastName(String lastName1, String lastName2);

    //greater less between
    List<Person> findAllAgeGreaterThan(int age);

    List<Person> findAllAgeBetween(int age1, int age2);

    //associated class
    List<Person> findAllByAddress_ZipCode(String zipCode);

    List<Person> findAllByLastNameIgnorCase(String lastName);

    //top first distinct
    Slice<Person> findTop3ByAge(int age);

    Slice<Person> findFirst10ByFirstName(String firstName);

    //stream support

    //asynchronized
    @Async
    Future<Person> findOne(String firstName);

    @Async
    CompletedFuture<Person> findOneByFirstName(String firstName);

    //@Query
    @Query("select u from User u where u.firstName = :firstName or u.lastName =:lastName" )
    Person findByLastNameOrFirstName( @Param("lastName" ) String lastName, @Param ("firstName" ) String firstName);


    @Modifying
    @Query("update Person p set p.age = p.age + ?2 where p.id = ?1")
    @Transactional
    void addAgeById(long id, int age);

    // hide other person info， more deligate than sql return object[]
    PersonInterface findById(long id);


}
