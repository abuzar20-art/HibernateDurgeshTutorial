package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		// Transaction is used just for saving the data .. here only data fetching is
		// done
//		 Student student= (Student)session.get(Student.class, 102);
//		System.out.println(student);

		Student student1 = (Student) session.load(Student.class, 102);
		System.out.println(student1.getName());

		Address address =(Address) session.get(Address.class, 2);
//		System.out.println(address.getStreet() + " : " + address.getCity());

//		Address address1 =(Address) session.get(Address.class, 2);
//		System.out.println(address1.getStreet() + " : " + address.getCity());
		
		factory.close();
	}
}
