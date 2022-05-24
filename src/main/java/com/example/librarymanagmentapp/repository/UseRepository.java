package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface UseRepository extends CrudRepository<User,Long> {
//    User findByLastName(String lastName);
//    User findByFirstName(String firstName);
//    User findByEmail(String email);
//    User findByPhone(String phone);
//    User findByAddress_City(String city);
//    User findByAddress_ZipCode(String zipcode);
//    User countAllBy();
//    User countByVisitingDate(LocalDate date);
}
