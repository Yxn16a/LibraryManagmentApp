package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "library")
public class Library extends BaseEntity{
    private String Name;
    @Embedded
    private Address address;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
    private Set<Book> books = new HashSet<>();
}
