package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "insurance")
public class InsuranceCompany extends Company{

    private Integer rating;


    @OneToOne(mappedBy = "insuranceCompany")
    private Car car;

    public InsuranceCompany() {

    }
    public InsuranceCompany(String name,Address address,Integer rating){
        super(name,address);
        this.rating = rating;
    }

}
