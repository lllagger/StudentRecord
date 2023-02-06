package com.DockerExampleMondoDB.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
public class Address {
    private String country;
    private String city;
    private String postCode;

    public Address(String country, String city, String postCode) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
    }
}
