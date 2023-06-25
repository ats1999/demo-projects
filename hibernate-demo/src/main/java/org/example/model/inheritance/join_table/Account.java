package org.example.model.inheritance.join_table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int acc_no;
    private int balance;
}
