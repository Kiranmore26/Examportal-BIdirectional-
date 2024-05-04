package com.Database.ExamportalProject.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;
import com.Database.ExamportalProject.model.Students;
import com.Database.ExamportalProject.model.Teachers;

public class TeacherDao 
{
	Scanner sc = new Scanner (System.in);

	
	public void insertTeacherDetails(Teachers teacher)
	{
		Transaction tx = null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			session.save(teacher);
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
	            
	           Teachers t =session.get(Teachers.class, id);
	            if(t!=null)
	            {
	            	session.delete(t);
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
	

	
	public void updateTeachers(int id) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Teachers t= session.get(Teachers.class,id );
            
            if(t!=null)
            {
            	System.out.println("What do you want to update");
            	System.out.println("1) Update Teachers Age");
            	System.out.println("2) Update Teachers Name");
            	System.out.println("3) Update Teachers  Password");
            	int choice=sc.nextInt();
            	switch (choice) 
            	{
				case 1:
					System.out.println("Enter new Age To update the data");
					t.setTeacherAge(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter new Name To update the data");
					t.setTeacherName(sc.next());
					break;
				case 3:
					System.out.println("Enter new Password To update the data");
					t.setTeacherPass(sc.next());
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
            }
            // save the student object
            session.update(t);
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

	
	
	
	
	public void displayTeachers() 
	{
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            List<Teachers> li=session.createQuery("from Teachers").getResultList();
            
            System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");

            for(Teachers t:li)
            {
            	System.out.println(t.getTeacherId()+"\t\t"+t.getTeacherName()+"\t\t"+t.getTeacherAge()+"\t\t"+t.getTeacherPass());
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
	
	
	
	
	
	public void customizeteachersTable()
	{
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            	Teachers t = new Teachers();
	            
	            	System.out.println("Choose from Below");
	            	System.out.println("1) Customize Table By Teachers Id");
	            	System.out.println("2) Customize Table by Teachers Name");
	            	System.out.println("3) Customize Table by Teachers Age");
	            	int choice=sc.nextInt();
	            	switch (choice) 
	            	{
					case 1:
						System.out.println("Enter the Id that you want to display");
						int id=sc.nextInt();
						
						Teachers tea=session.get(Teachers.class, id);
						
						if(tea!=null)
						{
							System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
			            	System.out.println(tea.getTeacherId()+"\t\t"+tea.getTeacherName()+"\t\t"+tea.getTeacherAge()+"\t\t"+tea.getTeacherPass());

						}
						break;
					case 2:
						System.out.println("Enter the name that you want to dispaly");
						String Name=sc.next();
						 
						List<Teachers> li2=session.createQuery("from Teachers where TeacherName=:Name").
								setParameter("Name", Name).getResultList();
						
						
						System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
						 for(Teachers s2:li2)
						 {
				            	System.out.println(s2.getTeacherId()+"\t\t"+s2.getTeacherName()+"\t\t"+s2.getTeacherAge()+"\t\t"+s2.getTeacherPass());

						 }
						
						break;
						
					case 3:
						System.out.println("Enter the name that you want to dispaly");
						int age=sc.nextInt();
						 
						List<Teachers> li3=session.createQuery("from Teachers where TeacherAge=:age").
								setParameter("age", age).getResultList();
						
						
						System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
						 for(Teachers s2:li3)
						 {
				            	System.out.println(s2.getTeacherId()+"\t\t"+s2.getTeacherName()+"\t\t"+s2.getTeacherAge()+"\t\t"+s2.getTeacherPass());

						 }
						
						break;
						
					default:
						System.err.println("Wrong Input");
						break;
					}
	            
	        }
	}
	
	
	
	
	
	
	
	
}
