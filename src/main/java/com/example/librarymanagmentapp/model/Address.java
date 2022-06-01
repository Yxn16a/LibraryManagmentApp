package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class  Address {
    private String StreetAddressOne;
    private String StreetAddressTwo;
    private String City;
    private String state;
    private String zipCode;
    private String Country;
    private String county;
}
