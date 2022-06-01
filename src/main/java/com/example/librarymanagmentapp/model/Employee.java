package com.example.librarymanagmentapp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {
    @Embedded
    private Person person;

    @ManyToOne
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;
    private String photo;
    private String username;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
