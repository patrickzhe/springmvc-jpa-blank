package com.example.mvc.specs;

import com.example.mvc.entity.Person;
import com.example.mvc.entity.Person_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
public class PersonSpecs{
    public static Specification<Person> isUnderAge(final Integer age) {
        return new Specification<Person>() {
            @Override public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThanOrEqualTo(root.<Integer>get(Person_.age), age);
            }

        };
    }

    public static Specification<Person> isFirstNameLike(final String firstName) {
        return new Specification<Person>() {
            @Override public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.<String>get("firstName"), getLikePattern(firstName));
            }

            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }
        };
    }

}
