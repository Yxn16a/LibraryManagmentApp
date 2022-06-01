package com.example.librarymanagmentapp.model;

import com.sun.istack.NotNull;
import jdk.jshell.SourceCodeAnalysis;
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
   @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private LocalDateTime publicationDate;
    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String isbn;
    private Integer numberOfPages;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private String subject;
    @Column(name = "barcode", length = 50, nullable = false, unique = true)
    private String barCode;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookFormat bookFormat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookItem")
    private BookItem bookItem;
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

    @ManyToOne
    @JoinColumn(name = "book_suggestion_id")
    private BookSuggestion bookSuggestion;
  @ManyToOne
  private Library library;

}
