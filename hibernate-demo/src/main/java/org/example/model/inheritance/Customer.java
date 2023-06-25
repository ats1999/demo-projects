package org.example.model.inheritance;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Customer  extends  Person{
    private String address;
    private int balance;
}
