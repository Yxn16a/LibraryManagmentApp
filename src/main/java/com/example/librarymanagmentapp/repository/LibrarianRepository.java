package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Librarian;
import org.springframework.data.repository.CrudRepository;

public interface LibrarianRepository extends CrudRepository<Librarian, Long> {
}
