package org.example.model.inheritance.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Credit extends Account{
    private int creditLimit;
}
