package com.entities;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Test {
    public static final Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Student student = new Student();
        student.setName("Tushar");
        student.setCity("Mevasa");
        student.setDateOfBirth("17-08-1999");
        logger.info(student);

        Address address = new Address();
        address.setCity("Jetpur");
        address.setAddDate(new Date());
        address.setOpen(false);
        address.setX(124.52);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();
        session.close();


    }

}
