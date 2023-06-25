package org.example.model.inheritance.single_table;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Saving extends Account{
    private int overDraftFee;
}
