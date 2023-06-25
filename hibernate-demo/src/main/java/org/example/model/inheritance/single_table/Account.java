package org.example.model.inheritance.single_table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int acc_no;
    private int balance;
}
