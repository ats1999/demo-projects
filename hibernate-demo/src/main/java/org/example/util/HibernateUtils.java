package org.example.util;

import org.example.model.User;
import org.example.model.UserWithColumnAnnotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    public static Session getSession() {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();


        Metadata metadata = new MetadataSources(serviceRegistry)
                // TODO: how can i scan a entire package, instead of individual classes?
                .addAnnotatedClasses(User.class, UserWithColumnAnnotation.class)
                .buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory.openSession();
    }
}
