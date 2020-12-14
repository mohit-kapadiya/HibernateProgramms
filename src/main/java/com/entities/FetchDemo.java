package com.entities;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static final Logger logger = Logger.getLogger(FetchDemo.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student student = session.load(Student.class, 2);
        logger.info(student);
        Student student1 = session.get(Student.class, 2);
        logger.info(student1);
        session.close();
        sessionFactory.close();
    }

}
