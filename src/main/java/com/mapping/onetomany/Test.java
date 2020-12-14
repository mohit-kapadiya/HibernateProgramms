package com.mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Question1 question1 = new Question1();
        question1.setId(106);
        question1.setQuestion("what is programming language?");

        Answer1 answer1 = new Answer1();
        answer1.setId(210);
        answer1.setAnswer("A programming language is a set of commands, instructions, and other syntax use to create a software program.");
        answer1.setQuestion1(question1);

        Answer1 answer2 = new Answer1();
        answer2.setId(211);
        answer2.setAnswer("Languages that programmers use to write code are called \"high-level languages.\" ");
        answer2.setQuestion1(question1);

        Answer1 answer3 = new Answer1();
        answer2.setId(212);
        answer3.setAnswer(" programming means to program a machine with a given set of instructions to run");
        answer3.setQuestion1(question1);

        List<Answer1> answer1List = new ArrayList<Answer1>();
        answer1List.add(answer1);
        answer1List.add(answer2);
        answer1List.add(answer3);
        question1.setAnswer1List(answer1List);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(question1);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);
        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
