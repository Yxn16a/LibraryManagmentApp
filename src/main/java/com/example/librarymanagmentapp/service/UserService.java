package com.example.librarymanagmentapp.service;

import com.example.librarymanagmentapp.model.LibraryUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface UserService {
    LibraryUser saveUser(LibraryUser libraryUser);

    Set<LibraryUser> getAllUsers();

    LibraryUser findByFirstName(String firstName);

    LibraryUser findByLastName(String lastName);

    List<LibraryUser> findByCity(String city);

    LibraryUser findUserByEmail(String email);

//    LibraryUser findByPhoneNumber(String phone);
//
//    LibraryUser countAllUsers();

    List<LibraryUser> countByVisitingDate(LocalDate date);

    List<LibraryUser> findUsersByCountry(String country);

    List<LibraryUser> findUsersByCity(String city);

    List<LibraryUser> findUsersByZip(String zipcode);

    List<LibraryUser> findUserByCounty(String county);

    LibraryUser updateUser(LibraryUser libraryUser, String email);

    void DeleteUserByEmail(String user);

}
