package com.cache;

import com.embedding.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel {
    public static final Logger logger = Logger.getLogger(FirstLevel.class);
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Employee employee=session.get(Employee.class,2);
        logger.info(employee.getName());

        logger.info("working something....");

        Employee employee2=session.get(Employee.class,2);
        logger.info(employee2.getName());

        //query will be fire only one time.Because object already store in catch memory.
        logger.info(session.contains(employee));

        session.close();
    }
}
