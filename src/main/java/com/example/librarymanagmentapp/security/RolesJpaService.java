package com.example.librarymanagmentapp.security;

import com.example.librarymanagmentapp.exception.ResourceNotFoundException;
import com.example.librarymanagmentapp.exception.UserAlreadyExistsException;
import com.example.librarymanagmentapp.model.LibraryUser;
import com.example.librarymanagmentapp.repository.LibraryUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RolesJpaService implements RolesServices{
    private final LibraryUserRepository libraryUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public Set<Roles> findUserRoles(LibraryUser libraryUser) {
        return libraryUser.getRoles();
    }

    @Override
    public Set<Roles> UserNonAssignedRoles(LibraryUser libraryUser) {
        return null;
    }

    @Override
    public void AssignUserRole(String email,Long roleId) throws UserAlreadyExistsException {
        LibraryUser libraryUser = libraryUserRepository.findByPersonEmailIgnoreCase(email);
        if(libraryUser != null){
            Roles roles = roleRepository.findById(roleId).orElse(null); // TODO find a better way to indenfy a user role
            Set<Roles> UserRoles = libraryUser.getRoles();
            UserRoles.add(roles);
            libraryUserRepository.save(libraryUser);
        }else{
            throw  new UserAlreadyExistsException("Customer already exists!!"); //TODO study the exceptions to make suere that it works
            // as it is supposed to work
        }
    }

    @Override
    public void UnAssignUserRole(String email, Long roleId) {
        LibraryUser libraryUser = libraryUserRepository.findByPersonEmailIgnoreCase(email);
        if(libraryUser != null){
            Set<Roles> UserRoles = libraryUser.getRoles();
            // check if the id you entered matched the role id
            UserRoles.removeIf(x->x.getId() == roleId);
            libraryUserRepository.save(libraryUser);
        }else{
            throw new ResourceNotFoundException("User","email",email);
        }
    }

}
