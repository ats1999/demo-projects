package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.Person;
import org.example.util.HibernateUtils;
import org.hibernate.LockMode;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();


//        Person p = new Person();
//        p.setName(faker.name().fullName());
//        p.setAmount(faker.number().numberBetween(100, 100 * 100));
//
//        System.out.println("Person: " + p);

//        Person p = session.get(Person.class, 1);
//        p.setAmount(p.getAmount() + 100);
//        session.beginTransaction();
//        session.persist(p);
//
//        System.out.println("Started persisting...");
//        Thread.sleep(2 * 60 * 1000);
//        System.out.println("Persisted the entity...");
//
//        session.getTransaction().commit();
//
//
        new Thread(new Runnable() {
            @Override
            public void run() {
                Session session = HibernateUtils.getSession(Person.class);
                Person p = session.get(Person.class,1);
                session.lock(p, LockMode.PESSIMISTIC_WRITE);
                p.setAmount(p.getAmount()+100);
                session.beginTransaction();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                session.persist(p);
                session.getTransaction().commit();
                System.out.println("Done1");
            }
        }).start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Session session = HibernateUtils.getSession();
//                Person p = session.get(Person.class,1);
//                session.lock(p, LockMode.PESSIMISTIC_WRITE);
//                p.setAmount(p.getAmount()+100);
//                session.beginTransaction();
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                session.persist(p);
//                session.getTransaction().commit();
//
//                System.out.println("Done2");
//            }
//        }).start();
    }
}
