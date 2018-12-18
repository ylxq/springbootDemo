package com.boot.demo.demo;

import com.boot.demo.demo.domain.Person;
import com.boot.demo.demo.domain.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest1 {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void contextLoads() {
      List<Person> list = personMapper.findPersons();
      list.forEach(p-> System.out.println(p.getName()));
    }

}
