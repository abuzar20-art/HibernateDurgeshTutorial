package com.map.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemos {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory(); 
        
        //creating question
//        Questions q1 = new Questions();
//        q1.setQuestionId(1212);
//        q1.setQuestion("What is Java ?");
        
        // creating answer
//        Answers answer = new Answers();
//        answer.setAnswerId(343);
//        answer.setAnswer("Java is programming language");
//        answer.setQuestion(q1);  // for birectional mapping
// 
//        Answers answer2 = new Answers();
//        answer2.setAnswerId(33);
//        answer2.setAnswer("With the help of Java we can create software");
//        answer2.setQuestion(q1);  // for birectional mapping
//        
//        Answers answer3 = new Answers();
//        answer3.setAnswerId(331);
//        answer3.setAnswer("Java has different type of frameworks");
//        answer3.setQuestion(q1);  // for birectional mapping
//        
//        List<Answers> list = new ArrayList<Answers>();
//        list.add(answer);
//        list.add(answer2);
//        list.add(answer3);
//        
//       q1.setAnswers(list);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
      
//        s.save(q1);   
//        s.save(answer);
//        s.save(answer2);
//        s.save(answer3);
        
        tx.commit();
       
//        fetching..
            Questions q = s.get(Questions.class, 1212);
            System.out.println(q.getQuestionId());
            System.out.println(q.getQuestion());
            //lazy loading
            System.out.println(q.getAnswers().size());
//        
//            for(Answers a : q.getAnswers()) {
//            	System.out.println(a.getAnswer());
//            }
            
           
            
            
        s.close();
        factory.close();
	}

}
