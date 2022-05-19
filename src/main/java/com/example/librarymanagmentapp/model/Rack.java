package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rack extends BaseEntity{
    private int number;
    private String locationIdentifier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
    private Set<BookItem> bookItem = new HashSet<>();
}
