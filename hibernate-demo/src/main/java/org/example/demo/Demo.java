package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.Address;
import org.example.model.Location;
import org.example.model.User;
import org.example.util.HibernateUtils;
import org.example.util.Utils;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        User user = new User();
        user.setName(faker.name().fullName());
        user.setAge(Utils.getRandomAge());

        // set tags - see model
        Set<String> tags = new HashSet<>();
        tags.add("Java");
        tags.add("C++");
        user.setTags(tags);

        // set marks
        Map<String,Integer> marks = new HashMap<>();
        marks.put("Java",90);
        marks.put("Python",10);
        user.setMarks(marks);

        // set address
        Address address = new Address();
        address.setHome(faker.address().streetAddress());
        address.setOffice(faker.address().secondaryAddress());
        user.setAddress(address);

        // set localtion
        Location location = new Location();
        location.setLatitude(12);
        location.setLongitude(90);
        address.setLocation(location);

        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();

        System.out.println("Saved: " + user);
    }
}
