package com.sovtech.sovtech_se_assessment_on_graphql.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Repository extends PagingAndSortingRepository<Person, Integer> {
    Page<Person> findByName(String name, Pageable pageable);
}

