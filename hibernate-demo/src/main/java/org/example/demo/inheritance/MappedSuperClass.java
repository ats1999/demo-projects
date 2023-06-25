package org.example.demo.inheritance;

import com.github.javafaker.Faker;
import org.example.model.inheritance.mapped_super_class.Credit;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class MappedSuperClass {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Credit creditAcc = new Credit();
        creditAcc.setBalance(faker.number().numberBetween(1,10000));
        creditAcc.setOwner(faker.name().fullName());
        creditAcc.setCreditLimit(faker.number().numberBetween(10000,20000));

        session.beginTransaction();
        session.persist(creditAcc);
        session.getTransaction().commit();
    }
}
