package com.seughyun.java.project03.aims.repository;

import com.seughyun.java.project03.aims.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
//test

@SpringBootTest
class PersonRepositoryTest  {

    @Autowired
    private PersonRepository personRepository;


    @Test
    void crud(){
        Person person = new Person();
        person.setName("justin");
        person.setAge(15);

        personRepository.save(person);

//        System.out.println(personRepository.findAll());
        List<Person> people = personRepository.findAll();

        Assertions.assertEquals(people.size(),1);
        Assertions.assertEquals(people.get(0).getName(),"justin");
        Assertions.assertEquals(people.get(0).getAge(),15);

    }


}