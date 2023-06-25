package org.example.model.association;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    private College college;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Subject> subject;
}
