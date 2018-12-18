package com.boot.demo.demo.controller;

import com.boot.demo.demo.domain.mapper.PersonMapper;
import com.boot.demo.demo.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/list")
    public String users(Model model) {
        model.addAttribute("users", personRepository.findAll());
        return "index";
    }

    @Autowired
    private PersonMapper personMapper;


    @GetMapping("/list1")
    public String users1(Model model) {
        model.addAttribute("users", personMapper.findPersons());
        return "index";
    }
}
