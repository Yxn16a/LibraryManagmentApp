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
@Table(name = "Account")
public class Account extends BaseEntity {
    @Embedded
    private Person person;
    //    @OneToOne(mappedBy = "account")
//    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name = "accountStatus")
    private AccountStatus accountStatus;
//      @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
//       private Set<Book> book;
    //  @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name = "member_id", referencedColumnName = "id")
//   private Member member;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "librarian_id", referencedColumnName = "id")
//    private Librarian librarian;

}
