package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Person {
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;
    private String firstName;
    private String lastName;
    private String email; //TODO Validate email
    private String phoneNumber;
    private String password;
}
