package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory(); 
        
        //creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java ?");
        
        // creating answer
        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is programming language");
        answer.setQuestion(q1);  // for birectional mapping
        q1.setAnswer(answer);
        
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is Collection framework?");
        
        // creating answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(344);
        answer2.setAnswer("API to work with objects in Java");
        answer2.setQuestion(q2);
        q2.setAnswer(answer2);
        
        
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
      
        s.save(answer);
        s.save(q1);
        s.save(answer2);
        s.save(q2);
        tx.commit();
       
        //fetching...
         Question qs = (Question)s.get(Question.class, 1212);
         System.out.println(qs.getQuestion());
         System.out.println(qs.getAnswer().getAnswer());
        
        s.close();
        factory.close();
	}

}
