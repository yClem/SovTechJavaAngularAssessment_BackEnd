package com.sovtech.sovtech_se_assessment_on_graphql.person;

import com.sovtech.sovtech_se_assessment_on_graphql.person.Person;
import lombok.Data;

import java.util.List;

/**
 * todo :: make this a response entity object. i.e generic for all entities
 */
@Data
public class Persons {
    private List<Person> person;
    private Integer totalPages;
    private Long totalElements;
    private Integer numberOfElements;
    private Integer size;
    private Integer number;
}
