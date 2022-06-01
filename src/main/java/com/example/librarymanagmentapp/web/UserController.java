package com.example.librarymanagmentapp.web;

import com.example.librarymanagmentapp.exception.ResourceNotFoundException;
import com.example.librarymanagmentapp.model.LibraryUser;
import com.example.librarymanagmentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/user/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<LibraryUser> saveUsers(@RequestBody LibraryUser libraryUser) {

        return new ResponseEntity<LibraryUser>(userService.saveUser(libraryUser), HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    public Set<LibraryUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/find/firstname/{firstname}")
    public LibraryUser findUserByFirstName(@PathVariable("firstname") String firstName) {
        return userService.findByFirstName(firstName);
    }

    @GetMapping("/find/lastname/{lastname}")
    public LibraryUser findUserByLastName(@PathVariable("lastname") String lastName) {
        return userService.findByLastName(lastName);
    }

    @GetMapping("/find/email/{email}")
    public LibraryUser findUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }
    @PutMapping("/update/email/{email}")
    // ResponseEntity help with adding a body
    public ResponseEntity<LibraryUser> updateUser(@PathVariable("email") String email,
                                                  @RequestBody LibraryUser libraryUser) {
        return new ResponseEntity<LibraryUser>(userService.updateUser(libraryUser, email), HttpStatus.OK);
    }
    // fix validation in service when a wrong isbn is passed
    @DeleteMapping("/delete/user/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable("email") String email) {
        LibraryUser libraryUser = userService.findUserByEmail(email);
        if(libraryUser ==null){
            throw new ResourceNotFoundException("LibraryUser","email",email);

        }else{
            userService.DeleteUserByEmail(email);
            return new ResponseEntity<String>("LibraryUser deleted successfully", HttpStatus.OK);
        }
    }
}
