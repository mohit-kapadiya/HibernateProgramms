package com.hql.nativesql;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;


public class SqlExample {
    public static final Logger logger = Logger.getLogger(SqlExample.class);
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        NativeQuery nativeQuery=session.createSQLQuery("select  * from  Employee");
        List<Object[]> list =nativeQuery.list();
        for(Object[] objects:list){
            logger.info(Arrays.toString(objects));
        }

        session.close();
        sessionFactory.close();
    }
}
