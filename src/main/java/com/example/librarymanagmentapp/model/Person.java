package com.example.librarymanagmentapp.model;

import javax.persistence.*;

@Embeddable
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;
    @Embedded
    private Address address;
}
