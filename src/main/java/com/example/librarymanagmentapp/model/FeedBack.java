package com.example.librarymanagmentapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "u_ser_id")
    private LibraryUser libraryUser;
    private String description; //TODO make this a text
}
