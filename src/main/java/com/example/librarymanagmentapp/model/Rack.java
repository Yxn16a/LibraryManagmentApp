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
@Table(name = "rack")
public class Rack extends BaseEntity {
    private String number;
    private String locationIdentifier;

    @OneToMany(mappedBy = "rack")
    private Set<Book> books = new HashSet<>();
}
