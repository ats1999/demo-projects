package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.UserWithColumnAnnotation;
import org.example.util.HibernateUtils;
import org.example.util.Utils;
import org.hibernate.Session;

public class ColumnNames {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        UserWithColumnAnnotation user = new UserWithColumnAnnotation();
        user.setName(faker.name().fullName());
        user.setAge(Utils.getRandomAge());

        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();

        System.out.println("Saved User" + user);
    }
}
