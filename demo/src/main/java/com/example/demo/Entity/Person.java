package com.example.demo.Entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private int age;
    private Date birth;
    private Pet pet;
    private String[] interets;
    private List<String> animals;
    private Map<String,Integer> score;
    private Set<Double> salary;
//    private Map<String,List<Pet>> allPet;


}
