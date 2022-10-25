package com.sovtech.sovtech_se_assessment_on_graphql.seeder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Result{
    public String name;
    public String height;
    public String mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public List<String> films;
    public List<String> species;
    public List<String> vehicles;
    public List<String> starships;
    public Date created;
    public Date edited;
    public String url;

}
