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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="author")
public class Author extends BaseEntity {
    @Embedded
    private Person person;
    private String description;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
