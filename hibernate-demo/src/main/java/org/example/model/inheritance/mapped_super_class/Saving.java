package org.example.model.inheritance.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Saving extends Account{
    private int overDraftFee;
}
