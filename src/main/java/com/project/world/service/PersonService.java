package com.project.world.service;

import com.project.world.entity.Address;
import com.project.world.entity.Person;
import com.project.world.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

        initSomePerson();
    }

    @Deprecated
    public void initSomePerson() {
        Address address = Address.builder()
                .city("中国")
                .country("成都")
                .build();

        Person person = Person.builder()
                .firstname("test1")
                .build();

        Example<Person> example = Example.of(person);

        personRepository.count();

        Page<Person> personPage = personRepository.findAll(new PageRequest(1, 1, Sort.Direction.ASC, "id"));

        Long currentIdMax = personPage.getTotalElements();

        List<Person> peopleList = new ArrayList<>();
        for (long id = currentIdMax; id < currentIdMax + 10; id++) {

            peopleList.add(
                    Person.builder()
                            .id(Long.toString(id))
                            .firstname("test" + id)
                            .lastname("test-last" + id)
                            .address(address)
                            .build()
            );
        }

        personRepository.saveAll(peopleList);
    }
}
