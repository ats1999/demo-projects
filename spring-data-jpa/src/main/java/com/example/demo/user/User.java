package com.example.demo.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Embeddable
class Subject {
	private String name;
	private int marks;
//	@ElementCollection
	private List<String> tags;
}

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int age;

//	@ElementCollection
//	private List<String> tags;
//	private Set<String> tags;
//	private  Map<Integer,String> tags;

	@Embedded
	@ElementCollection
	private List<Subject> subjects;
}
