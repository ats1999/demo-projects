package org.example.model.inheritance.join_table;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Saving extends  Account{
    private int overDraftFee;
}
