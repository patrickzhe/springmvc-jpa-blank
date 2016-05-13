package com.example.mvc.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hzchenzhe1 on 2016/5/12.
 */
@Entity
@Table(name = "ADDRESS")
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String zipCode;

    private String address;

    private String country;

    private String province;

    private String city;
}
