package com.example.mvc.specs;

import com.mysema.query.types.expr.BooleanExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
public class PersonPredicatesBuilder {
    /*private List<SearchCriteria> params;

    public PersonPredicatesBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public PersonPredicatesBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = new ArrayList<BooleanExpression>();
        PersonPredicate predicate;
        for (SearchCriteria param : params) {
            predicate = new PersonPredicate(param);
            BooleanExpression exp = predicate.getPredicate();
            if (exp != null) {
                predicates.add(exp);
            }
        }

        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }*/
}
