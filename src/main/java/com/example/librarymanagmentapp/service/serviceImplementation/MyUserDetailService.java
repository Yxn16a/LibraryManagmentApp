package com.example.librarymanagmentapp.service.serviceImplementation;

import com.example.librarymanagmentapp.model.LibraryUser;
import com.example.librarymanagmentapp.model.UserPrincipal;
import com.example.librarymanagmentapp.repository.LibraryUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    // we will take user and find user by username
    private final LibraryUserRepository libraryUserRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     LibraryUser libraryUser=  libraryUserRepository.findByPersonEmailIgnoreCase(email);
      if(libraryUser == null){
          throw new UsernameNotFoundException("user not found");
      }
      // you need to return a principal or a wrapper for the user
        // you can not just return a user
       return new UserPrincipal(libraryUser);
    }
}
