package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HqlPagination {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

       Session session = factory.openSession();
     //  Query query = session.createQuery("from Student") ;
       Query<Student> query = session.createQuery("from Student", Student.class); // optional to write
       query.setFirstResult(0);
       query.setMaxResults(5);
       
                List<Student> list = query.list();
              for( Student st : list ) {
            	  System.out.println(st.getId() + " : " + st.getName() + " : " + st.getCity());
              }
        
       session.close();
        factory.close();
	}

}
