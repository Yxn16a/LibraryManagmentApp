package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
