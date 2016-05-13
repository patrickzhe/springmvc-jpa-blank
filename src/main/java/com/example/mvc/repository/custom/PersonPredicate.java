package com.example.mvc.repository.custom;

import com.example.mvc.entity.Person;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.StringPath;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
@AllArgsConstructor
public class PersonPredicate {
    private SearchCriteria criteria;

    public BooleanExpression getPredicate() {
        PathBuilder<Person> entityPath = new PathBuilder<Person>(Person.class, "person");

        if (StringUtils.isNumeric(criteria.getValue().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.eq(value);
            }
            else if (criteria.getOperation().equalsIgnoreCase(">")) {
                return path.goe(value);
            }
            else if (criteria.getOperation().equalsIgnoreCase("<")) {
                return path.loe(value);
            }
        }
        else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            }
        }
        return null;
    }
}
