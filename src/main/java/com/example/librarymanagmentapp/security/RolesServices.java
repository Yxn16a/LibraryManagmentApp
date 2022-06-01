package com.example.librarymanagmentapp.security;

import com.example.librarymanagmentapp.exception.UserAlreadyExistsException;
import com.example.librarymanagmentapp.model.LibraryUser;

import java.util.List;
import java.util.Set;

public interface RolesServices {
    Set<Roles> findUserRoles(LibraryUser libraryUser);
    Set<Roles> UserNonAssignedRoles(LibraryUser libraryUser);
    void AssignUserRole(String email,Long roleId) throws UserAlreadyExistsException;
    void UnAssignUserRole(String email,Long roleId);

}
