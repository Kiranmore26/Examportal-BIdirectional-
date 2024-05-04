package com.Database.ExamportalProject.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;

public class PaperDao 
{
	Scanner sc = new Scanner (System.in);
	
	public void insertPaperDetails(Papers paper)
	{
		Transaction tx = null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			session.save(paper);
			tx.commit();
		}
		catch (Exception e) 
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void deleteStudentById(int id) 
	{
		Transaction tx = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
	            tx = session.beginTransaction();
	            
	            Papers p =session.get(Papers.class, id);
	            if(p!=null)
	            {
	            	session.delete(p);
	            }
	            tx.commit();
	        } 
	        catch (Exception e) 
	        {
	            if (tx != null) 
	            {
	                tx.rollback();
	            }
	            e.printStackTrace();
	            
	        }
	
	}
	
	
	
	
	public void updatePapers(int id) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Papers p = session.get(Papers.class, id);
   
            if(p!=null)
            {
            	System.out.println("What do you want to update");
            	System.out.println("1) Update Paper Name");
            	System.out.println("2) Update Paper Subject");
            	System.out.println("3) Update Paper Type");
            	int choice=sc.nextInt();
            	switch (choice) 
            	{
				case 1:
					System.out.println("Enter new Paper name To update the data");
					p.setPaperName(sc.next());
					break;
				case 2:
					System.out.println("Enter new Paper Subject To update the data");
					p.setPaperSubject(sc.next());
					break;
				case 3:
					System.out.println("Enter new Paper type To update the data");
					p.setPaperType(sc.next());
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
            }
            // save the student object
            session.update(p);
            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
	
	
	public void displayPaper() 
	{
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            List<Papers> li=session.createQuery("from Papers").getResultList();
            
            System.out.println("PaperId\t\tPaperName\tPaperSubject\tPaperType");
            for(Papers p:li)
            {
            	System.out.println(p.getPaperId()+"\t\t"+p.getPaperName()+"\t\t"+p.getPaperSubject()+"\t\t"+p.getPaperType());
            }
            
            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	

	
	
	
	
}
