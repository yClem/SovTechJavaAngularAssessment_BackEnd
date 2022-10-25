package com.sovtech.sovtech_se_assessment_on_graphql.person;

import com.sovtech.sovtech_se_assessment_on_graphql.person.Person;
import lombok.Data;

import java.util.List;

@Data
public class Persons {
    public List<Person> person;
    public int totalPages;
    public long totalElements;
    public int numberOfElements;
    public int size;
    public int number;
}
