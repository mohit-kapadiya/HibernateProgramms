package com.hql;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


public class ComplexHqlQuery {
    public static final Logger logger = Logger.getLogger(ComplexHqlQuery.class);
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        // Delete Query

        Transaction transaction=session.beginTransaction();
        String query="Delete from Question s where s.id=1219";
        Query query1 =session.createQuery(query);
        int result=query1.executeUpdate();
        logger.info("delete :"+result);

        logger.info("*************************************************************");

        //Update Query

        Query query2=session.createQuery("update Employee  set city=:c where name=:x");
        query2.setParameter("c","Baroda");
        query2.setParameter("x","Uday");
        int result1=query2.executeUpdate();
        logger.info("update :"+result1);
        transaction.commit();

        logger.info("*************************************************************");

        //Join Column
        Query query3=session.createQuery("select q.question ,q.id,a.answer from Question1 as q INNER join q.answer1List as a");
        List<Object[]> list= query3.getResultList();
        for(Object[] array:list){
            logger.info(Arrays.toString(array));
        }
        session.close();
        sessionFactory.close();



    }

}
