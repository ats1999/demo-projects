package org.example.demo;

import org.example.model.Person;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class NativeSQL {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSession(Person.class);

        // native sql retrieving all columns
        session
                .createNativeQuery("SELECT * FROM PERSON", Person.class)
                .getResultList()
                .forEach(System.out::println);


        // retrieving only selected columns
        List<Object[]> list = session.createNativeQuery("select name,amount from person", Object[].class).getResultList();
        list.forEach(o -> {
            System.out.println(o[0] + ", " + o[1]);
        });


    }
}
