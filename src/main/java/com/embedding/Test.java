package com.embedding;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Uday");
        employee.setCity("Amreli");

        Car car = new Car();
        car.setCarName("Alto");
        car.setPrice("200000");
        employee.setCar(car);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        factory.close();

    }
}
