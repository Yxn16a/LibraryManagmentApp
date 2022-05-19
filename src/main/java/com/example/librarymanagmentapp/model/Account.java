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
@Table(name= "Account")
public class Account extends BaseEntity{
   private String password;
   @Enumerated(EnumType.STRING)
   @Column(name ="accountStatus")
   private AccountStatus accountStatus;
   @OneToOne(mappedBy = "account")
   private Person person;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
   private Set<Book> book = new HashSet<>();

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "member_id", referencedColumnName = "id")
   private Member member;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "librarian_id", referencedColumnName = "id")
   private Librarian librarian;


   public void resetPassWord(String password){

   }
   public void reserveBook(){

   }
   public void borrowBook(){

   }

}
