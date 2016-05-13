package com.example.mvc.repository.custom;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
