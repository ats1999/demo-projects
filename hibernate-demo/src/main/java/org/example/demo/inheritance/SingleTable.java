package org.example.demo.inheritance;

import com.github.javafaker.Faker;
import org.example.model.inheritance.single_table.Saving;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class SingleTable {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Saving savingAcc = new Saving();
        savingAcc.setOverDraftFee(faker.number().numberBetween(20000,50000));
        savingAcc.setBalance(50000);

        session.beginTransaction();
        session.persist(savingAcc);
        session.getTransaction().commit();
    }
}
