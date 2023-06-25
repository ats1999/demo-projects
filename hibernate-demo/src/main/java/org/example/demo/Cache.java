package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.cache.Person;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class Cache {
    public static void main(String[] args) throws InterruptedException {
        Session session = HibernateUtils.getSession(Person.class);
        Faker faker = new Faker();

        // create a new person
        Person newPerson = new Person();
        newPerson.setName(faker.name().fullName());
        newPerson.setBalance(faker.number().numberBetween(100, 100 * 100));

        // save newly created person into database
        session.beginTransaction();
        session.persist(newPerson);
        session.getTransaction().commit();

        while (true){
            Person oldPerson = session.get(Person.class,1);
            System.out.println(oldPerson);
            Thread.sleep(1000);

            // try to modify the database record for id 1, you'll get to see the same value...
        }
    }
}
