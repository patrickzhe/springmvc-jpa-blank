package com.example.mvc.specs;

import com.example.mvc.entity.Person;
import com.example.mvc.entity.Person_;
import com.sun.tools.javac.code.Attribute;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
public class PersonSpecs{
    public static Specification<Person> isUnderAgeAndFirstNameLike(final Integer age, final String firstName) {
        return new Specification<Person>() {
            @Override public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.and(cb.lessThanOrEqualTo(root.<Integer>get(Person_.age), age),cb.like(root.<String>get("firstName"), getLikePattern(firstName)));
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
