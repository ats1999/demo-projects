package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class AnnotationConfigDemo {

    private static void insertRandomUsers(int numOfUsers, SessionFactory sessionFactory) {
        Faker faker = new Faker();

        try (
                Session session = sessionFactory.openSession()
        ) {
            for (int i = 0; i < numOfUsers; i++) {
                User user = new User();

                int age = (int) Math.round(Math.random() * 150);
                user.setAge(age);
                user.setName(faker.name().fullName());

                session.beginTransaction();
                session.persist(user);
                session.getTransaction().commit();

                System.out.println("Saved: " + user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build()
        ) {
            Metadata metadata = new MetadataSources(serviceRegistry)
                    // TODO: how can i scan a entire package, instead of individual classes?
                    .addAnnotatedClass(User.class)
                    .buildMetadata();

            try (
                    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            ) {
                insertRandomUsers(100, sessionFactory);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
