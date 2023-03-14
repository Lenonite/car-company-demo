package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
@Embedded
private Address address;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Company() {
    }


}
