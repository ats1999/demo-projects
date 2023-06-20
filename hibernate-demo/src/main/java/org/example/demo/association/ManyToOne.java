package org.example.demo.association;

import com.github.javafaker.Faker;
import org.example.model.association.College;
import org.example.model.association.Student;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class ManyToOne {
    static void insertNewRecord() {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setAge(faker.number().numberBetween(20, 30));

        College college = new College();
        college.setName(faker.university().name());

        student.setCollege(college);

        session.beginTransaction();
        session.persist(student);
        session.persist(college);
        session.getTransaction().commit();
    }

    static void insertNewRecordWithOldCollege(Session session) {
        Faker faker = new Faker();
        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setAge(faker.number().numberBetween(20, 30));

        College college = session.get(College.class, faker.number().numberBetween(1, 10));
        student.setCollege(college);

        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Long startTime = System.currentTimeMillis();

        for (var i = 0; i < 10; i++) {
//            insertNewRecord();
            insertNewRecordWithOldCollege(session);
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime - startTime));
    }
}
