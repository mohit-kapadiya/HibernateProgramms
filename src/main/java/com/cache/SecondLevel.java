package com.cache;


import com.embedding.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevel {
    public static final Logger logger = Logger.getLogger(SecondLevel.class);
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Employee employee = session1.get(Employee.class, 2);
        //first
        logger.info(employee.getName());
        session1.close();

        Session session2 = sessionFactory.openSession();
        Employee employee2 = session2.get(Employee.class, 2);
        //second
        logger.info(employee2.getName());
        session2.close();
        sessionFactory.close();
    }
}
