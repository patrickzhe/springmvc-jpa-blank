package com.example.mvc.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
public interface PersonInterface {

    public String getFirstName();

    public String getLastName();

    //composite return value SPEL could use regEx
    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();

}
