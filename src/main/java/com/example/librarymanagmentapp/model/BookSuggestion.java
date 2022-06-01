package com.example.librarymanagmentapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BookSuggestion extends BaseEntity {
    @OneToMany(mappedBy = "bookSuggestion")
    private Set<Book> books = new HashSet<>();
}
