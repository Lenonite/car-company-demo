package com.example.carcompany.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    private String road;

    public Address() {
    }

    public Address(String road) {
        this.road = road;
    }
}
