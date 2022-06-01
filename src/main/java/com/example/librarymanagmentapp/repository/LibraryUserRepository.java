package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.LibraryUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LibraryUserRepository extends CrudRepository<LibraryUser, Long> {
    LibraryUser findByPersonLastNameLikeIgnoreCase(String lastName);

    LibraryUser findByPersonFirstNameLikeIgnoreCase(String firstName);

    LibraryUser findByPersonEmailIgnoreCase(String email);

    // LibraryUser findPersonByPhone(String phone);

    //LibraryUser countAllBy();

    List<LibraryUser> countByVisitingDate(LocalDate date);

    @Query(value = "SELECT u.firstName, u.lastName from LibraryUser u where u.address.country = ?1",
            nativeQuery = true)
    List<LibraryUser> getUsersByCountry(String country);

    @Query(value = "SELECT u.firstName, u.lastName from LibraryUser u where u.address.city = ?1",
            nativeQuery = true)
    List <LibraryUser> findUserByCity(String city);

    @Query(value = "SELECT u.firstName, u.lastName from LibraryUser u where u.address.zipCode = ?1", nativeQuery = true)
    List<LibraryUser> findUserByZip(String zipcode);

    @Query(value = "SELECT u.firstName, u.lastName from LibraryUser u where u.address.county = :county", nativeQuery = true)
    List<LibraryUser> findUserByCounty(@Param("county") String county);
}
