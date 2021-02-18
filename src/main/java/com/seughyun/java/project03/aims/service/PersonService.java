package com.seughyun.java.project03.aims.service;

import com.seughyun.java.project03.aims.domain.Block;
import com.seughyun.java.project03.aims.domain.Person;
import com.seughyun.java.project03.aims.repository.BlockRepository;
import com.seughyun.java.project03.aims.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
}
