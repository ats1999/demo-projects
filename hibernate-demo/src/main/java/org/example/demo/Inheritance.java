package org.example.demo;

import com.github.javafaker.Faker;
import org.example.model.inheritance.Customer;
import org.example.model.inheritance.Employee;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

public class Inheritance {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession();

        Employee employee = new Employee();
        employee.setDept(faker.company().industry());
        employee.setName(faker.name().fullName());
        employee.setAge(23);

        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();

        System.out.println("Saved: " + employee);


        // save customer
        Customer customer = new Customer();
        customer.setAddress(faker.address().secondaryAddress());
        customer.setBalance(4500);
        customer.setName(faker.name().fullName());
        customer.setAge(25);

        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();

    }
}
