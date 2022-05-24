package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User extends BaseEntity {
    @Embedded
    private Person person;
    @OneToMany(mappedBy = "user")
    private Set<Belongings> belongings = new HashSet<>();
    private LocalDate visitingDate;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    private Account account;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "member_id", referencedColumnName = "id")
//    private Member member;
}
