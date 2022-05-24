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
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    @Embedded
//    private Address address;
//   @OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
//    private Set<BookItem> bookItem = new HashSet<>();
}
