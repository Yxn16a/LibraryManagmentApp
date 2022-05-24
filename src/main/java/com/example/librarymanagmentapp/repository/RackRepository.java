package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Rack;
import org.springframework.data.repository.CrudRepository;

public interface RackRepository extends CrudRepository<Rack,Long> {
//    Rack countAll();
//    Rack findByLocationIdentifier(String locationIdentifier);
}
