package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "manufacturer")
public class CarManufacturar extends Company{

    private Integer noOfemp;
    private LocalDate yearsPublished;

    public CarManufacturar(String name, Address address, Integer noOfemp, LocalDate yearsPublished) {
        super(name, address);
        this.noOfemp = noOfemp;
        this.yearsPublished = yearsPublished;

    }

    public CarManufacturar() {

    }
    @OneToOne(mappedBy = "carManufacturar")
    private Car car;
}
