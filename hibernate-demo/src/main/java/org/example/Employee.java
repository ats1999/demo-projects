package org.example;

import lombok.Data;
import java.util.Date;

@Data
public class Employee {
    private int id;
    private String name;
    private String role;
    private Date insertTime;
}