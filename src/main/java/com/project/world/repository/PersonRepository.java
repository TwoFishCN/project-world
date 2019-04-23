package com.project.world.repository;

import com.project.world.entity.Person;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.List;

public interface PersonRepository extends KeyValueRepository<Person, String> {

    List<Person> findByFirstname(String firstname);
}