package com.tut;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App  
{
    public static void main( String[] args ) throws IOException 
    { 
        System.out.println( "project started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory(); 
        
        //creating student
        Student st = new Student();
        st.setId(103); 
        st.setName("Rahul");
        st.setCity("Kanpur");
     System.out.println(st);
     
        Address ad = new Address();
        ad.setStreet("streeet no 14");
        ad.setCity("Delhi"); 
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.12);
        
        // reading image
        FileInputStream fis = new FileInputStream("src/main/java/lk .jpg");
          byte[] data = new byte[fis.available()];
          fis.read(data);
          ad.setImage(data);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        //session.save(ad);
        tx.commit();
        
        
        session.close();
        fis.close();
        System.out.println("Done...");
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
    }
}
