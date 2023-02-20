package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(4241);
		student1.setName("Shikha");
		student1.setCity("Jabalpur");

		Certificate certi = new Certificate();
		certi.setCourse("Post Doc");
		certi.setDuration("2 Yr");

		student1.setCerti(certi);
		

		Student student2 = new Student();
		student2.setId(14258);
		student2.setName("Rahul Sahu");
		student2.setCity("Kanpur");

		Certificate certi1 = new Certificate();
		certi1.setCourse("M.Tech");
		certi1.setDuration("2 Yr");

		student2.setCerti(certi1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	//   objects save
		session.save(student2);		
		session.save(student1);
		tx.commit();
		
		session.close();
		
		factory.close();
	}

}
