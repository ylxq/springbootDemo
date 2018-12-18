package com.boot.demo.demo.controller;

import com.boot.demo.demo.domain.mapper.PersonMapper;
import com.boot.demo.demo.domain.repository.PersonRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/persons")
    public ResponseEntity findPerson() {
       return ResponseEntity.ok( personRepository.findAll());
    }

}
