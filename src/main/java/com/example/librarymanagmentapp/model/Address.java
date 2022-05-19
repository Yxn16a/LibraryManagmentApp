package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Address")
public class  Address extends BaseEntity {
    private String StreetAddress;
    private String City;
    private String state;
    private String zipCode;
    private String Country;
    private String county;
    @OneToOne(mappedBy = "address")
    private Person person;
    @OneToOne(mappedBy = "address")
    private Library library;
}
