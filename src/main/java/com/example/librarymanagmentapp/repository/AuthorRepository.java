package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
