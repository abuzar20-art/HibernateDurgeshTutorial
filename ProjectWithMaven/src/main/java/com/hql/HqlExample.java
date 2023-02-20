package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HqlExample {

	public static void main(String[] args) {
		
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
		
	        Session session = factory.openSession();
	        
	        // HQL syntax
	  //      String query = "from Student where city = 'Lucknow'" ;   // entity name
	     //   String query = "from Student where city =:x " ;   // for taking dynamic value
	        String query = "from Student as s where s.city =:x and s.name =:n " ;  
	        Query q = session.createQuery(query);
	        q.setParameter("x", "Goa");
	        q.setParameter("n", "Samuel Kaka");
	        List<Student> list = q.list();
	      
	        list.stream().forEach(student -> 
	        System.out.println(student.getName() + " : " + student.getCerti().getCourse()));
	      //  list.stream().forEach(System.out::println);

	        System.out.println("__________________________");
	        
	            Transaction tx = session.beginTransaction();
	            
	            // Delete query
//	       Query deleteQuery = session.createQuery("delete from Student as st where st.city =:c");
//	       deleteQuery.setParameter("c", "Goa");
//	        int noOfRows = deleteQuery.executeUpdate();
//	        System.out.println("Deleted:");
//	        System.out.println(noOfRows);
	            
	      // update query
	         Query updateQuery = session.createQuery("update Student set city =:c where name =:n");
	         updateQuery.setParameter("c", "Delhi");
	         updateQuery.setParameter("n", "Rishabh Tiwari");
	          int rowsUpdated = updateQuery.executeUpdate();
	          System.out.println("Updated: ");
	          System.out.println(rowsUpdated);
	          
	          tx.commit();
	          
	// execute join query
	        Query joinQuery = session.createQuery("select q.questionId, q.Question, a.answer from  Questions as q INNER JOIN q.answers as a");
	            List<Object[]> list3 = joinQuery.getResultList();
	            for(Object[] arr : list3) {
	            	System.out.println(Arrays.toString(arr));
	            }
	       
	      
	        session.close();
	        factory.close();
	}
}
