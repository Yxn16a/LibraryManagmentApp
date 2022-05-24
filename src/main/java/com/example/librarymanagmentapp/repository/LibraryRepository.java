package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library,Long> {
}
