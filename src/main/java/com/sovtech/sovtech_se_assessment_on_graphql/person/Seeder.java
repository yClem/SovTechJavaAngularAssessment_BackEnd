package com.sovtech.sovtech_se_assessment_on_graphql.person;

import com.sovtech.sovtech_se_assessment_on_graphql.seeder.Result;
import com.sovtech.sovtech_se_assessment_on_graphql.seeder.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class Seeder implements ApplicationRunner {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private Repository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /**
         * todo :: see if you can seed from file system i.e. .csv file...
         */
        try {
            log.info("Loading data. Please wait...");
            Root root = webClient.build()
                    .get()
                    .uri("https://swapi.dev/api/people")
                    .retrieve()
                    .bodyToMono(Root.class)
                    .block();

            log.info("Data loaded successfully ["+root.toString()+"]");
            Person person;
            List<String> films = new ArrayList<>();
            List<String> species = new ArrayList<>();
            List<String> vehicles = new ArrayList<>();
            List<String> starships = new ArrayList<>();

            for (Result result :
                    root.results) {
                person = new Person();
                person.setName(result.getName());
                person.setHeight(result.getHeight());
                person.setMass(result.getMass());
                person.setHair_color(result.getHair_color());
                person.setSkin_color(result.getSkin_color());
                person.setEye_color(result.getEye_color());
                person.setBirth_year(result.getBirth_year());
                person.setGender(result.getGender());
                person.setHomeworld(result.getHomeworld());
                person.setCreated(new Date());
                person.setEdited(new Date());
                person.setUrl(result.getUrl());

                for (int index = 0; index < result.getFilms().size(); index++) {
                    films.add(result.getFilms().get(index));
                }

                for (int index = 0; index < result.getVehicles().size(); index++) {
                    vehicles.add(result.getVehicles().get(index));
                }

                for (int index = 0; index < result.getSpecies().size(); index++) {
                    species.add(result.getSpecies().get(index));
                }

                for (int index = 0; index < result.getStarships().size(); index++) {
                    starships.add(result.getStarships().get(index));
                }

                person.setFilms(films);
                person.setSpecies(species);
                person.setVehicles(vehicles);
                person.setStarships(starships);
                personRepository.save(person);
            }
        } catch (Exception e) {
            log.error("Error loading data -> ["+e.getMessage()+"]");
        }
    }
}
