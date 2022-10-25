package com.sovtech.sovtech_se_assessment_on_graphql.person;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;

    @ElementCollection
    @CollectionTable(name = "my_films", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "films")
    public List<String> films;

    @ElementCollection
    @CollectionTable(name = "my_species", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "species")
    public List<String> species;

    @ElementCollection
    @CollectionTable(name = "my_vehicles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "vehicles")
    public List<String> vehicles;

    @ElementCollection
    @CollectionTable(name = "my_starships", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "starships")
    public List<String> starships;

    public Date created;
    public Date edited;
    public String url;
}
