package com.example.librarymanagmentapp.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long> {
    @Query(
            value = "select u.roles from LibraryUser u where u.roles " +
                    "not in (select * from Roles)",
            nativeQuery = true
    )
    Set<Roles> getUserNonAssignedRoles(String email);
}
