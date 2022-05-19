package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "members")
public class Member extends BaseEntity {
    private LocalDateTime membershipDate;
    private int totalBooksCheckedOut;
    @OneToOne(mappedBy = "member")
    private Account account;

}
