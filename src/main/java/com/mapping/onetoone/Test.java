package com.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();

        Question question1=new Question();
        question1.setId(1223);
        question1.setQuestion("what is springboot");

        Answer answer1=new Answer();
        answer1.setId(354);
        answer1.setAnswer( "Spring Boot is an open source Java-based framework used to create a micro Service");
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(question1);
        session.save(answer1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
