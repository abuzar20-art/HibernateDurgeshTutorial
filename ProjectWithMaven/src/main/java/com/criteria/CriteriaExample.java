package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	public static void main(String[] args) {

	       	  Session s = new Configuration().configure().buildSessionFactory().openSession();
	       	  
	       	 Criteria cr = s.createCriteria(Student.class);
	       	 
	     //  	 cr.add(Restrictions.eq("certi.course", "M.Tech"));
	       	 cr.add(Restrictions.gt("id", 14123));

	       	 
	       	   List<Student> students = cr.list();
	       	   for(Student  st : students) {
	       		   System.out.println(st);
	       	   }
	       	  
	       	  s.close();
	}

}
