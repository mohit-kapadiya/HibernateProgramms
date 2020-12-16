package com.hql;

import com.mapping.onetoone.Question;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlPagination {
    public static final Logger logger = Logger.getLogger(HqlPagination.class);
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Question ");
        query.setFirstResult(1);
        query.setMaxResults(6);
        List<Question> list=query.list();
        for(Question question:list){
            logger.info(question.getId()+" "+question.getQuestion());
        }
        session.close();
        sessionFactory.close();
    }
}
