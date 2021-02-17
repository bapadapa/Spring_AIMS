package com.seughyun.java.project03.aims.repository;


import com.seughyun.java.project03.aims.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
