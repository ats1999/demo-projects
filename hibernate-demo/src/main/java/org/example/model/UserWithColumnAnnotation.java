package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserWithColumnAnnotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userName")
    private String name;
    private int age;
}
