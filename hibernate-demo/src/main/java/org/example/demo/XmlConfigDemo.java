package org.example.demo;

import org.example.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.Date;

public class XmlConfigDemo {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        try(
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .configure()
                        .build();

                SessionFactory sessionFactory = configuration
                        .buildSessionFactory(serviceRegistry);

                Session session = sessionFactory
                        .openSession();
        ){
            Employee emp = new Employee();
            emp.setName("Pankaj");
            emp.setRole("CEO");
            emp.setInsertTime(new Date());

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Employee is saved!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
