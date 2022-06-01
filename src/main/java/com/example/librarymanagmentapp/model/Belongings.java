package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "belongings")
public class Belongings extends BaseEntity {
    private String books;
    private String otherBelongings;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private LibraryUser libraryUser;
    @Enumerated(EnumType.STRING)
    @Column(name = "computer_type")
    private ComputerType computerType;
}






