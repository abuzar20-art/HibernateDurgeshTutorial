package com.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;



public class SecondLevelCache {

	public static void main(String[] args) {

		//EhcacheRegionFactory //to get complete package name in factory cfg
		
		      SessionFactory factory = new Configuration().configure().buildSessionFactory();
		                          Session session1 = factory.openSession();
		                         Student student1 = session1.get(Student.class, 14257);   
		                         System.out.println(student1);
		                          session1.close();
		                          
		                          Session session2 = factory.openSession();
		                          Student student2 = session2.get(Student.class, 14257); 
		                          System.out.println(student2);
		                          session2.close();
		                          
		      factory.close();
	}

}
