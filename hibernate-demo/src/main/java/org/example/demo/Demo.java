package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.Person;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class Demo {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession(Person.class);

        // insert 100 persons
        session.beginTransaction();
        Long startTime = System.currentTimeMillis();

        for (var i = 0; i < 100 * 100*100; i++) {
            Person p = new Person();
            p.setAmount(faker.number().numberBetween(1000, 1000 * 100));
            p.setName(faker.name().fullName());
            session.persist(p);
        }
        session.getTransaction().commit();
        Long endTime = System.currentTimeMillis();

        System.out.println("Inserted records in: " + (endTime - startTime) / 1000);
    }
}
