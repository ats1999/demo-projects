package org.example.model.inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee extends Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String empId;
    private String dept;
}
