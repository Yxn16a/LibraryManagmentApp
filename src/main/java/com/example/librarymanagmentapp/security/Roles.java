package com.example.librarymanagmentapp.security;

import com.example.librarymanagmentapp.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends BaseEntity {
    private Long id;
    private String description;
    private String details;
}
