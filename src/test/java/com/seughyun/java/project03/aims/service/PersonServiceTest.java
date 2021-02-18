package com.seughyun.java.project03.aims.service;

import com.seughyun.java.project03.aims.domain.Block;
import com.seughyun.java.project03.aims.domain.Person;
import com.seughyun.java.project03.aims.repository.BlockRepository;
import com.seughyun.java.project03.aims.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeropleExcludeBlock();

        //System.out.println(result);

        result.forEach(System.out::println);

    }

    private void givenBlocks() {
        givenBlock("Justin");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));

    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(givenBlock(name));
        personRepository.save(blockPerson);
    }


    private void givenPeople() {
        givenPerson("Justin", 10, "A");
        givenPerson("David", 9, "B");
        givenBlockPerson("Dennis", 7, "O");
        givenBlockPerson("Martin", 6, "AB");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));

    }


}