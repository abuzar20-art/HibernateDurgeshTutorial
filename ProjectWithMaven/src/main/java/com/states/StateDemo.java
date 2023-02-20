package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		
		// Practical of Hibernate object states
		
		System.out.println("Example:   ");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object:
		Student student = new Student();
		student.setId(123);
		student.setName("Tabeeb");
		student.setCity("SKB");
		student.setCerti(new Certificate("Data Science", "8 months"));
		//student : Transient state
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//student : Persistent - session, database
		student.setName("Usama");
		
		tx.commit();
		
//		  Student student1 = s.get(Student.class, 123);
//		s.delete(student1);
		
		s.close();
		// student : Detached state
		student.setName("Ahmad");
		System.out.println(student);
		
		factory.close();
		
	}

}
