package com.seughyun.java.project03.aims.service;

import com.seughyun.java.project03.aims.domain.Block;
import com.seughyun.java.project03.aims.domain.Person;
import com.seughyun.java.project03.aims.repository.BlockRepository;
import com.seughyun.java.project03.aims.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j  //로그 이용하기 편하게 만들어줌.
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeropleExcludeBlock(){
        List<Person> poeple = personRepository.findAll();

        return poeple.stream().filter(person -> person.getBlock()==null).collect(Collectors.toList());

        //List<Block> blocks = blockRepository.findAll();
        //List<String> blockName = blocks.stream().map(Block::getName).collect(Collectors.toList());
        //return poeple.stream().filter(person -> !blockName.contains(person.getName())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        Person person = personRepository.findById(id).get();
        System.out.println("person : " + person);
        log.info("person  : {} " ,person);

        return person;
    }
}
