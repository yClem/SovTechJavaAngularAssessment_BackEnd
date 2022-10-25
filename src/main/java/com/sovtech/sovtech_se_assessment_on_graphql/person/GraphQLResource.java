package com.sovtech.sovtech_se_assessment_on_graphql.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphQLResource {

    @Autowired
    private Repository personRepository;

    @QueryMapping
    public Persons persons(@Argument int page, @Argument int size) {
        Page<Person> person = personRepository.findAll(PageRequest.of(page, size));

        /**
         * todo :: mv to service layer
         */
        Persons persons = new Persons();
        persons.setPerson(person.getContent());
        persons.setNumber(person.getNumber());
        persons.setSize(person.getSize());
        persons.setNumberOfElements(person.getNumberOfElements());
        persons.setTotalPages(person.getTotalPages());
        persons.setTotalElements(person.getTotalElements());
        return persons;
    }

    /**
     * todo :: use e-search
     */
    //@SchemaMapping(typeName = "Query", value = "person")
    @QueryMapping
    public Persons findPersonByName(@Argument String name, @Argument int page, @Argument int size) {
        Page<Person> person = personRepository.findByName(name, PageRequest.of(page, size));

        /**
         * todo :: mv to service layer
         */
        Persons persons = new Persons();
        persons.setPerson(person.getContent());
        persons.setNumber(person.getNumber());
        persons.setSize(person.getSize());
        persons.setNumberOfElements(person.getNumberOfElements());
        persons.setTotalPages(person.getTotalPages());
        persons.setTotalElements(person.getTotalElements());
        return persons;
    }

    //@SchemaMapping(typeName = "Query", value = "person")
    @QueryMapping
    public Optional<Person> findPersonById(@Argument int id) {
        return personRepository.findById(id);
    }

}
