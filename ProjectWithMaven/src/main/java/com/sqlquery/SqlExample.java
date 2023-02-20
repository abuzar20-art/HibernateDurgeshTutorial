package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SqlExample {

	public static void main(String[] args) {
		
		   SessionFactory factory = new Configuration().configure().buildSessionFactory();
		                    Session session = factory.openSession();
		       
		                    //SQL query
		       String q ="select * from Student";             
		     NativeQuery nq = session.createSQLQuery(q) ;     
		              List<Object[]> list =nq.list();
		                    
		              for(Object[] student : list) {
		            	//  System.out.println(Arrays.toString(s));
		            	  System.out.println(student[4] + " : " + student[3]);  // index pos of column from table
		              }
		              
		                    
		                    session.close();
		   factory.close();
	}

}
