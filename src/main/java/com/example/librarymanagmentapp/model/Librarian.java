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
@Table(name= "Librarian")
public class Librarian extends BaseEntity {
    @ManyToMany
    @JoinTable(
            name = "librarian_bookitem",
            joinColumns = @JoinColumn(name = "librarian_id"),
            inverseJoinColumns = @JoinColumn(name = "bookitem_id"))
    private Set<BookItem> bookitem = new HashSet<>();
    @OneToOne(mappedBy = "librarian")
    private Account account;

    public boolean addBookItem(Book book) {
        return true;
    }

    public boolean blockMember(Account account) {
        return true;
    }

    public boolean unblockMember(Account account) {
        return true;
    }
}
