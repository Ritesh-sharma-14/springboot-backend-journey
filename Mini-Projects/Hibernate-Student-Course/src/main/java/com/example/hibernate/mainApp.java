
package com.project;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create courses
        Course c1 = new Course("Java Programming", "Ravi Kumar");
        Course c2 = new Course("Python Fundamentals", "Sneha Sharma");
        Course c3 = new Course("Spring Boot", "Amit Verma");

        // Create student
        Student s1 = new Student("Ritesh Sharma", "ritesh@example.com");
        Student s2 = new Student("Ananya Patel", "ananya@example.com");

        // Assign courses
        s1.getCourses().add(c1);
        s1.getCourses().add(c3);

        s2.getCourses().add(c1);
        s2.getCourses().add(c2);

        // Save students (courses auto-saved due to CascadeType.ALL)
        session.persist(s1);
        session.persist(s2);

        tx.commit();
        session.close();
        HibernateUtil.shutdown();

        System.out.println("✅ Data inserted successfully!");
    }
}
