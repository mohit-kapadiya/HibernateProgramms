package com.hql;


import com.embedding.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        String query4="from Employee where name=:x";
        Query query5=session.createQuery(query4);
        query5.setParameter("x","Uday");

        List<Employee> employees2=query5.list();
        for(Employee employee:employees2){
            logger.info(employee.getCity()+" "+employee.getId()+" "+employee.getCar());
        }

        String query6="from Employee as s where s.city=:x and s.name=:y ";
        Query query7=session.createQuery(query6);
        query7.setParameter("x","Amreli");
        query7.setParameter("y","Uday");
        List<Employee> employees3=query7.list();
        for(Employee employee:employees3){
            logger.info(employee.getId()+"  "+employee.getCar());
        }


        sessionFactory.close();
    }
}
