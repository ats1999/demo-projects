package org.example.demo;

import com.github.javafaker.Faker;
import jakarta.persistence.TypedQuery;
import org.example.model.Person;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

record DTO(String name, Long id) {

}

public class HQL_AND_JPQL_Demo {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Session session = HibernateUtils.getSession(Person.class);

        // Simple query API
        TypedQuery<Person> typedQuerySimple = session.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> personListSimple = typedQuerySimple.getResultList();
        System.out.println("Persons: " + personListSimple.size());
        System.out.println(personListSimple.size());

        // limit clause does not works in JQPL, we'll have to use setMaxResults for limiting result
        typedQuerySimple.setMaxResults(10);
        List<Person> personListWithLimit = typedQuerySimple.getResultList();
        System.out.println(personListWithLimit.size());

        // print persons
        personListWithLimit.forEach(System.out::println);
//
        // TODO: check why session.createQuery("...") is deprecated

        Query<Person> queryForSelectedAttributes = session.createQuery("SELECT p FROM Person p", Person.class);
        queryForSelectedAttributes.setMaxResults(2);
        List<Person> personListWithOnlyName = queryForSelectedAttributes.getResultList();
        personListWithOnlyName.forEach(System.out::println);

//         setting params
        session
                .createQuery("SELECT p FROM Person p WHERE p.name LIKE :name")
                .setParameter("name", "%ab%")
                .setMaxResults(2)
                .getResultList()
                .forEach(p -> {

                });

        // pagination
        session
                .createQuery("SELECT p FROM Person p")
                // skip
                .setFirstResult(1)
                // limit
                .setMaxResults(2)
                .getResultList()
                .forEach(System.out::println);


        try {
            // will throw error - not a selection query
            session.createSelectionQuery("delete Person p");

            // will throw error - not a mutation query
            session.createMutationQuery("select p from Person p");
        } catch (Exception ex) {
            // noop
        }


        // query without select
        System.out.println("\n\nQuery without select clause:");
        session.createSelectionQuery("from Person")
                .setMaxResults(2)
                .getResultList()
                .forEach(System.out::println);


        session.beginTransaction();
        String newName = faker.name().fullName();
        // update entity
        int numEntityUpdated = session
                .createMutationQuery("UPDATE Person  SET name = :newName where id=:id")
                .setParameter("newName", newName)
                .setParameter("id", 1L)
                .executeUpdate();
        session.flush();
        session.getTransaction().commit();

        Person updatedPerson1 = session.get(Person.class, 1L);
        Person updatedPerson2 = session
                .createSelectionQuery("select p from Person p where p.id=:id", Person.class)
                .setParameter("id", 1)
                .getSingleResult();

        System.out.println(numEntityUpdated + " : entity updated");
        System.out.println("New name: " + newName);
        System.out.println("Updated person1: " + updatedPerson1);
        System.out.println("Updated person2: " + updatedPerson2);

        /**
         * Problem with the above code block
         * We are updating entity with createMutationQuery(SQL)
         * createMutationQuery will not update hibernate cache
         *  Person updatedPerson1 = session.get(Person.class, 1L); -->> we are getting this person information from cache and it'll be old person
         *  TODO: check why updatedPerson2 is not updating immediately
         */


        session.beginTransaction();
        String newNameForSessionUpdate = faker.name().fullName();
        Person personToUpdate = session.get(Person.class, 1L);
        personToUpdate.setName(newNameForSessionUpdate);
        session.getTransaction().commit();

        Person updatedPerson3 = session.get(Person.class,1L);
        Person updatedPerson4 = session
                .createSelectionQuery("select p from Person p where p.id=:id", Person.class)
                .setParameter("id", 1)
                .getSingleResult();
        System.out.println("New newNameForSessionUpdate: " + newNameForSessionUpdate);
        System.out.println("Updated person3: " + updatedPerson3);
        System.out.println("Updated person4: " + updatedPerson4);
    }
}
