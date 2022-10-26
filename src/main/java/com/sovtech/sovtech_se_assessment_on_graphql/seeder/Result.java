package com.sovtech.sovtech_se_assessment_on_graphql.seeder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Result{
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private Date created;
    private Date edited;
    private String url;

}
