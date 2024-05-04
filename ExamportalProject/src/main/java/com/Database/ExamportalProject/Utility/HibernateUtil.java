package com.Database.ExamportalProject.Utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;
import com.Database.ExamportalProject.model.Students;
import com.Database.ExamportalProject.model.Teachers;



public class HibernateUtil 
{
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		
		if(sessionFactory==null)
		{
			try
			{
				Configuration cfg = new Configuration();
				Properties p=new Properties();
				
				 p.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				 p.put(Environment.URL,"jdbc:mysql://localhost:3306/examportal" );
				 p.put(Environment.USER, "root");
				 p.put(Environment.PASS,"root" );
				 p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				 p.put(Environment.SHOW_SQL, "true");
				 p.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				 p.put(Environment.HBM2DDL_AUTO, "update");
				 cfg.setProperties(p);
				 cfg.addAnnotatedClass(Marks.class)
				 .addAnnotatedClass(Students.class)
				 .addAnnotatedClass(Teachers.class)
				 .addAnnotatedClass(Papers.class);
				
				 
				 
//		StandardServiceRegistry is an interface
				 StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().
						 applySettings(cfg.getProperties()).build();
				 
				 sessionFactory=cfg.buildSessionFactory(serviceRegistry);
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
		return sessionFactory;
	}
	
}
