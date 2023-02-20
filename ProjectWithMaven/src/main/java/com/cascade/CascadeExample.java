package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.oneToMany.Answers;
import com.map.oneToMany.Questions;

public class CascadeExample {

	public static void main(String[] args) {

     SessionFactory factory = new Configuration().configure().buildSessionFactory();
		         Session s = factory.openSession();
		         
		         Questions q1 = new Questions();
		         q1.setQuestionId(1335);
		         q1.setQuestion("What is Swing framework ?");
		         
		         Answers a1 =  new Answers(351, "used for development");
		         Answers a2 =  new Answers(352, "Desktop");
		         Answers a3 =  new Answers(353, "learn by programmers");
		         
		            List<Answers> answers = new ArrayList<>();
		            answers.add(a1);
		            answers.add(a2);
		            answers.add(a3);
		            
		            q1.setAnswers(answers);
		        Transaction tx = s.beginTransaction();
		            s.save(q1);
	// by cascade =ALL , all answers for the question will be saved automatically 	          
//		            s.save(a1);
//		            s.save(a2);
//		            s.save(a3);
		            
		           tx.commit(); 
		          s.close();
		          factory.close();
	}

}
