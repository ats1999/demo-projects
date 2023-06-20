package org.example.model.association;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @ManyToOne
    private College college;
}
