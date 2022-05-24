package com.example.librarymanagmentapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book extends BaseEntity {

    private String title;
    private String publisher;
    private LocalDateTime publicationDate;
    private String isbn;
    private Integer numberOfPages;
    private String language;
    private String subject;
    private String barCode;
    @Enumerated(EnumType.STRING)
    private BookFormat bookFormat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookItem")
    private BookItem bookItem;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "rack_books")
    private Rack rack;

}
