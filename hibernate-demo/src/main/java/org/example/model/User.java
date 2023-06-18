package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @ElementCollection
    // a new table will be created with foreign key refrence
    private Set<String> tags;

    @ElementCollection
    private Map<String,Integer> marks;

    @Embedded
    private Address address;
}
