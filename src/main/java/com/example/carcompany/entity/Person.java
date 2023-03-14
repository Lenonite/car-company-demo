package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    private LocalDate dob;


    public Person() {
    }

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;

    }
    @JoinColumn(name = "car_id_fk")
    @ManyToOne
    private Car car1;
    @JoinTable(name = "driver_car",joinColumns = @JoinColumn(name = "driver_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "car_id",referencedColumnName = "id"))
    @ManyToOne
    private Car car2;
}
