package org.example.model.inheritance.single_table;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Credit extends Account{
    private int creditLimit;
}
