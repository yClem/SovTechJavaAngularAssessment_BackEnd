package com.sovtech.sovtech_se_assessment_on_graphql.seeder;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class Root{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer count;
    private String next;
    private String previous;
    protected List<Result> results;

}
