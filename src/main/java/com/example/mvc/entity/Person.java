package com.example.mvc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE LOWER(p.firstName) = LOWER(?1)")
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    @Size(min = 1, max = 30)
    @NotNull
    private String name;

    @Column(name = "age")
    @Min(1)
    @Max(200)
    @NotNull
    private Integer age;

    private String lastName;

    private String firstName;

    @Column(name = "creation_time", nullable = false)
    private Date creationTime;

    @Column(name = "modification_time", nullable = false)
    private Date modificationTime;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @Version
    private long version = 0;

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
