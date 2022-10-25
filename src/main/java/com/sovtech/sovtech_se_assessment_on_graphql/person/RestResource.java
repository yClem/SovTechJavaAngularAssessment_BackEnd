package com.sovtech.sovtech_se_assessment_on_graphql.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class RestResource {

    @Autowired
    private Repository personRepository;

    @GetMapping(value = {"/persons"})
    public Page<Person> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "size", required = false, defaultValue = "20") int size) {
        return personRepository.findAll(PageRequest.of(page, size));
    }

    /**
     * todo :: use e-search
     */
    @GetMapping(value = {"/person/name/{name}"})
    public Page<Person> findByName(@PathVariable(value = "name") String name, @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                         @RequestParam(value = "size", required = false, defaultValue = "20") int size) {
        return personRepository.findByName(name, PageRequest.of(page, size));
    }

    @GetMapping(value = {"/person/id/{id}"})
    public Optional<Person> findById(@PathVariable(value = "id") Integer id) {
        return personRepository.findById(id);
    }
}
