package com.mapping.onetomany.cashcade;

import com.mapping.onetomany.Answer1;
import com.mapping.onetomany.Question1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CashCadExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Question1 question1 = new Question1();
        question1.setQuestion("What is CashCad ?");
        question1.setId(147);

        Answer1 answer1 = new Answer1();
        answer1.setId(105);
        answer1.setAnswer("Cascade example (save, update, delete and delete-orphan) Cascade is a convenient feature to save the lines of code needed to manage the state of the other side manually");

        Answer1 answer2 = new Answer1();
        answer2.setId(106);
        answer2.setAnswer("The “Cascade” keyword is often appear on the collection mapping to manage the state of the collection automatically");

        Answer1 answer3 = new Answer1();
        answer3.setId(107);
        answer3.setAnswer("CascadeType PERSIST propagates the persist operation from a parent to a child entity. When we save the person entity, the address entity will also get saved.");

        List<Answer1> answer1s = new ArrayList<Answer1>();
        answer1s.add(answer1);
        answer1s.add(answer2);
        answer1s.add(answer3);
        question1.setAnswer1List(answer1s);

        Transaction transaction = session.beginTransaction();
        session.save(question1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
