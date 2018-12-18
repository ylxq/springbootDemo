package com.boot.demo.demo;

import com.boot.demo.demo.domain.Person;
import com.boot.demo.demo.domain.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void contextLoads() {
      List<Person> list = personRepository.findAll();
      list.forEach(p-> System.out.println(p.getName()));
    }

}
