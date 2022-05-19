package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "bookItem")
public class BookItem extends BaseEntity{
    private String barCode;
    private boolean isReferenceOnly;
    private LocalDateTime borrowed;
    private LocalDateTime dueDate;
    private double price;
    @Enumerated(EnumType.STRING)
    private BookFormat bookFormat;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    private LocalDateTime dateOfPurchase;
    private LocalDateTime publicationDate;
    @ManyToOne
    @JoinColumn(name="library_id", nullable=false)
    private Library library;
    @OneToOne(mappedBy = "bookItem")
    private Book book;
    @ManyToMany(mappedBy ="bookitem")
    private Set<Librarian> librarian = new HashSet<>();
    @ManyToOne
    @JoinColumn(name="rack_id", nullable=false)
    private Rack rack;
}
