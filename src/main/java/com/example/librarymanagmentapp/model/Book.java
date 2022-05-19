package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name= "author")
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
    @Enumerated(EnumType.STRING)
    private BookFormat bookFormat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookItem bookItem;
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;


}
