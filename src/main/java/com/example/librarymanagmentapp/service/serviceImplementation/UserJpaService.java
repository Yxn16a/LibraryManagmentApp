package com.example.librarymanagmentapp.service.serviceImplementation;

import com.example.librarymanagmentapp.exception.ResourceNotFoundException;
import com.example.librarymanagmentapp.model.LibraryUser;
import com.example.librarymanagmentapp.repository.LibraryUserRepository;
import com.example.librarymanagmentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@Service
public class UserJpaService implements UserService {
    private final LibraryUserRepository libraryUserRepository;
    private final BCryptPasswordEncoder encoder;
    @Override
    public LibraryUser saveUser(LibraryUser libraryUser) {
        LibraryUser existingLibraryUser = libraryUserRepository.findByPersonEmailIgnoreCase(libraryUser.getPerson().getEmail());
        if( existingLibraryUser != null){
           System.out.println("libraryUser exist already");
           return null;
       }else{
            libraryUser.getPerson().setPassword(encoder.encode(libraryUser.getPerson().getPassword()));
           libraryUserRepository.save(libraryUser);
           return libraryUser;
       }
    }

    @Override
    public Set<LibraryUser> getAllUsers() {
        Set<LibraryUser> libraryUsers =new HashSet<>();
        libraryUserRepository.findAll().forEach(libraryUsers::add);
        return libraryUsers;
    }

    @Override
    public LibraryUser findByFirstName(String firstName) {
        return libraryUserRepository.findByPersonFirstNameLikeIgnoreCase(firstName);
    }

    @Override
    public LibraryUser findByLastName(String lastName) {
        return libraryUserRepository.findByPersonLastNameLikeIgnoreCase(lastName);
    }

    @Override
    public List <LibraryUser> findByCity(String city) {
        return libraryUserRepository.findUserByCity(city);
    }

    @Override
    public LibraryUser findUserByEmail(String email) {
        return libraryUserRepository.findByPersonEmailIgnoreCase(email);
    }

//    @Override
//    public LibraryUser findByPhoneNumber(String phone) {
//        return null;
//    }

//    @Override
//    public LibraryUser countAllUsers() {
//        return null;
//    }

    @Override
    public List<LibraryUser> countByVisitingDate(LocalDate date) {
        return null;
    }

    @Override
    public List<LibraryUser> findUsersByCountry(String country) {
        return null;
    }

    @Override
    public List<LibraryUser> findUsersByCity(String city) {
        return null;
    }

    @Override
    public List<LibraryUser> findUsersByZip(String zipcode) {
        return null;
    }

    @Override
    public List<LibraryUser> findUserByCounty(String county) {
        return null;
    }

    @Override
    public LibraryUser updateUser(LibraryUser libraryUser, String email) {
       LibraryUser existingLibraryUser = libraryUserRepository.findByPersonEmailIgnoreCase(email);
       if(existingLibraryUser == null){
          throw  new ResourceNotFoundException("libraryUser","Email",email);
       }else {
           existingLibraryUser.getPerson().setFirstName(libraryUser.getPerson().getFirstName());
           existingLibraryUser.getPerson().setLastName(libraryUser.getPerson().getLastName());
           existingLibraryUser.getPerson().setEmail(libraryUser.getPerson().getEmail());
           existingLibraryUser.getPerson().setPhoneNumber(libraryUser.getPerson().getPhoneNumber());
           existingLibraryUser.setBelongings(libraryUser.getBelongings());
           existingLibraryUser.getPerson().setPassword(libraryUser.getPerson().getPassword());
           existingLibraryUser.setAddress(libraryUser.getAddress());
           libraryUserRepository.save(existingLibraryUser);
           return existingLibraryUser;
       }
    }
    @Override
    public void DeleteUserByEmail(String userEmail) {
        LibraryUser libraryUser = libraryUserRepository.findByPersonEmailIgnoreCase(userEmail);
        if(libraryUser == null){
            throw new ResourceNotFoundException("Book","isbn",userEmail);
        }else{
            libraryUserRepository.delete(libraryUser);
        }
    }
}
