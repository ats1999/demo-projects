package org.example.demo;

import jakarta.persistence.EntityManager;
import org.example.model.User;
import org.example.model.inheritance.Person;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class SearchDB {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();
        Person u = session.get(Person.class,103);
        System.out.println(u);
    }
}
