package com.example.demo.Controller;

import com.example.demo.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        return person;
    }

    public String a;
    //注释
}
