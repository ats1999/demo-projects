package org.example;

import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class Employee {
    private int id;
    private String name;
    private String role;
    private Date insertTime;
    private Set<String> tags;
}