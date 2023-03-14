package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String model;
    private String make;
    private  LocalDate year;
    private Integer millage;
    @OneToMany(mappedBy = "car1",cascade = CascadeType.PERSIST)
    private List<Person> owners=new ArrayList<>();
@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "car2")
    private List<Person>drivers=new ArrayList<>();


    @OneToOne
    private CarManufacturar carManufacturar;
    @JoinTable(name = "car_insurance",joinColumns = @JoinColumn(name = "car_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "insurance_id",referencedColumnName = "id"))
    @OneToOne
    private InsuranceCompany insuranceCompany;

    public Car() {
    }

    public Car(String model, String make, LocalDate year, Integer millage) {

        this.model = model;
        this.make = make;
        this.year = year;
        this.millage = millage;
    }
    public void addOwner(Person person){
        person.setCar1(this);
        owners.add(person);
    }

    public void addDriver(Person person){
        person.setCar2(this);
        drivers.add(person);
    }


}
