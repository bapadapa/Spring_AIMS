package com.seughyun.java.project03.aims.repository;

import com.seughyun.java.project03.aims.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//test hello

@SpringBootTest
class PersonRepositoryTest  {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("justin");
        person.setAge(15);
        person.setBloodType("A");

        personRepository.save(person);

        System.out.println(personRepository.findAll());
        List<Person> people = personRepository.findAll();

        Assertions.assertEquals(people.size(),1);
        Assertions.assertEquals(people.get(0).getName(),"justin");
        Assertions.assertEquals(people.get(0).getAge(),15);
        Assertions.assertEquals(people.get(0).getBloodType(),"A");

    }

    @Test
    void ConstrictorTest(){
        Person person = new Person("justin",10,"A");


    }

    @Test
    void hashCodeAndEquals(){
        Person person1 =  new Person("martin", 10,"A");
        Person person2  = new Person("martin", 10,"B");
        //Person person2  = new Person("martin", 10,"A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());


        Map<Person,Integer> map = new HashMap<>();
        map.put(person1,person1.getAge());

        System.out.println(map);
        // 이렇게 가져오는 이유 --> 생성시마다 hash값이 변동됨. -> db에서 가져온 값을 동일한 키를 사용하기 위해 hashCode() 오버라이딩 해야한다.
        System.out.println(map.get(person2));

    }

}