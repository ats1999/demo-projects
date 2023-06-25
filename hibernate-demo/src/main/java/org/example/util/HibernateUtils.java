package org.example.util;

import org.example.model.Person;
import org.example.model.association.College;
import org.example.model.association.Student;
import org.example.model.association.Subject;
import org.example.model.inheritance.join_table.Account;
import org.example.model.inheritance.join_table.Credit;
import org.example.model.inheritance.join_table.Saving;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    public static Session getSession(Class... classes) {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();


        Metadata metadata = new MetadataSources(serviceRegistry)
                // TODO: how can i scan a entire package, instead of individual classes?
                .addAnnotatedClasses(classes).getMetadataBuilder().build();
//                .buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory.openSession();
    }
}
