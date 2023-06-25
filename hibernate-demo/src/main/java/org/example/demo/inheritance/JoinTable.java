package org.example.demo.inheritance;

import com.github.javafaker.Faker;
import org.example.model.inheritance.join_table.Saving;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class JoinTable {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Saving savingAcc = new Saving();
        savingAcc.setOverDraftFee(faker.number().randomDigitNotZero());
        savingAcc.setBalance(faker.number().randomDigitNotZero());

        session.beginTransaction();
        session.persist(savingAcc);
        session.getTransaction().commit();
    }
}
