package com.hql;


import com.embedding.Employee;
import com.entities.Test;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HqlClass {
    public static final Logger logger = Logger.getLogger(HqlClass.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        String query="from Employee";
        Query query1=session.createQuery(query);
        List<Employee> employees= query1.list();
        for(Employee employee:employees){
            logger.info(employee.getName()+" "+employee.getCity()+" "+employee.getId());
        }
        String query2="from Employee where id=2";
        Query query3=session.createQuery(query2);
        List<Employee> employees1=query3.list();
        for(Employee employee:employees1){
            logger.info(employee.getName()+" "+employee.getId()+" "+employee.getCity());
        }




        sessionFactory.close();
    }
}
