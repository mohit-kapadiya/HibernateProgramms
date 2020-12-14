package com.mapping.manytomany;

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

        Employees employee1 = new Employees();
        employee1.setId(101);
        employee1.setName("Mohit");

        Employees employee2 = new Employees();
        employee2.setId(102);
        employee2.setName("Uday");

        Projects project1 = new Projects();
        project1.setId(201);
        project1.setProjectName("Stock Market predictor");

        Projects project2 = new Projects();
        project2.setId(202);
        project2.setProjectName("sprigboot project");

        List<Projects> projects = new ArrayList<Projects>();
        projects.add(project1);
        projects.add(project2);

        List<Employees> employees = new ArrayList<Employees>();
        employees.add(employee1);
        employees.add(employee2);

        employee1.setProjects(projects);
        project2.setEmployeeList(employees);

        Session session = sessionFactory.openSession();
        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
