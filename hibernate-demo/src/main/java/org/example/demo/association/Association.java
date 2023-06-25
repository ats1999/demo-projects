package org.example.demo.association;

import com.github.javafaker.Faker;
import org.example.model.association.College;
import org.example.model.association.Student;
import org.example.model.association.Subject;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Association {
    static List<Subject> getSubjects(){
        Faker faker = new Faker();
        Subject subject1 = new Subject();
        subject1.setName(faker.book().title());
        subject1.setMarks(faker.number().numberBetween(30,100));


        Subject subject2 = new Subject();
        subject2.setName(faker.book().title());
        subject2.setMarks(faker.number().numberBetween(30,100));


        Subject subject3 = new Subject();
        subject3.setName(faker.book().title());
        subject3.setMarks(faker.number().numberBetween(30,100));

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        return subjects;
    }
    static void insertNewRecord() {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setAge(faker.number().numberBetween(20, 30));

        College college = new College();
        college.setName(faker.university().name());
        student.setCollege(college);
        student.setSubject(getSubjects());

        session.beginTransaction();
        session.persist(student);
        session.persist(college);
        session.getTransaction().commit();
    }

    static void insertStudents(Session session) {
        Faker faker = new Faker();
        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setAge(faker.number().numberBetween(20, 30));

        // get a college for the student
        College college = session.get(College.class, faker.number().numberBetween(1, 100));
        student.setCollege(college);

        // get a list of subjects for the student
        Subject subject1 = session.get(Subject.class, faker.number().numberBetween(1,100));
        Subject subject2 = session.get(Subject.class, faker.number().numberBetween(1,100));
        Subject subject3 = session.get(Subject.class, faker.number().numberBetween(1,100));
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        student.setSubject(subjects);

        // save student
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
    }


    static void init(Session session, Faker faker){
        // insert 100 colleges
        session.beginTransaction();

        for(var i=0; i<100; i++){
            College college = new College();
            college.setName(faker.university().name());
            session.persist(college);
        }

        // insert 100 subjects
        for(var i=0; i<100; i++){
            Subject subject = new Subject();
            subject.setName(faker.book().title());
            subject.setMarks(faker.number().numberBetween(30,100));
            session.persist(subject);
        }

        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();
        init(session,faker);

        for (var i = 0; i < 100; i++) {
            insertStudents(session);
        }
    }
}
