package com.project.world.repository;

import com.project.world.entity.Person;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface PersonRepository extends KeyValueRepository<Person, String> {
}