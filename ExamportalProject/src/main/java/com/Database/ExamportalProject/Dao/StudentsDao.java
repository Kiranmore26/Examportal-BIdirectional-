package com.Database.ExamportalProject.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Students;

public class StudentsDao 
{
	
	Scanner sc = new Scanner(System.in);
//	public void insert()
//	{
//		Transaction tx = null;
//		try (Session session=HibernateUtil.getSessionFactory().openSession())
//		{
//			tx=session.beginTransaction();
//			
//			Students s = new Students();
//			
//			System.out.println("Enter students Id");
//			s.setStudentId(sc.nextInt());
//			System.out.println("Enter students Name");
//			s.setStudentName(sc.next());
//			System.out.println("Enter students age");
//			s.setStudentAge(sc.nextInt());
//			System.out.println("Enter students Class");
//			s.setStudentClass(sc.next());
//			System.out.println("Enter Students Password ");
//			s.setStudentPassword(sc.next());
//			System.out.println("Enter marks id of that Student");
//			int markid=sc.nextInt();
//			
//			Marks m =session.get(Marks.class, markid);
//			
//			if(m!=null)
//			{
//				s.setMarksId(m);
//				session.save(s);
//				tx.commit();
//			}
//			else
//			{
//				System.err.println("Id not Found ");
//			}
//	
//		}
//		catch (Exception e) 
//		{
//			if(tx!=null)
//			{
//				tx.rollback();
//				e.printStackTrace();
//			}
//		}
//	}
	
	
	
	public void insertstudentsDetails(Students students) 
	{
		Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            tx = session.beginTransaction();
            // save the student object
            session.save(students);
            // commit transaction
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

	public void deleteStudentById(int id) 
	{
		Transaction tx = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            Students s=session.get(Students.class, id);
	            if(s!=null)
	            {
	            	session.delete(s);
	            }
	           
	             session.beginTransaction().commit();;
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
	
	
	public void updateStudents(int id) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Students s= session.get(Students.class,id );
//            Students ss = new Students();
            if(s!=null)
            {
            	System.out.println("What do you want to update");
            	System.out.println("1) Update Students Age");
            	System.out.println("2) Update Students Name");
            	System.out.println("3) Update Students Class");
            	System.out.println("4) Update Students Password");
            	int choice=sc.nextInt();
            	switch (choice) 
            	{
				case 1:
					System.out.println("Enter new Age To update the data");
					s.setStudentsAge(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter new Name To update the data");
					s.setStudentsName(sc.next());
					break;
				case 3:
					System.out.println("Enter new Class To update the data");
					s.setStudentsClass(sc.next());
					break;
				case 4:
					System.out.println("Enter new Password To update the data");
					s.setStudentsPass(sc.next());
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
            }
            // save the student object
            session.update(s);
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


	
	
	public void displayStudents() 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            List<Students> li=session.createQuery("from Students").getResultList();
            
            System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
            for(Students s:li)
            {
            	System.out.println(s.getStudentsId()+"\t\t"+s.getStudentsName()+"\t\t"+s.getStudentsAge()+"\t\t"+s.getStudentsClass()+"\t\t"+s.getStudentsPass());
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

	
	
	
	public void customizeStudentsTable()
	{
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            Students ss = new Students();
	            
	            	System.out.println("Choose from Below");
	            	System.out.println("1) Customize Table By Students Id");
	            	System.out.println("2) Customize Table by Students Name");
	            	System.out.println("3) Customize Table by Students Age");
	            	System.out.println("4) Customize Table by Students Class");
	            	int choice=sc.nextInt();
	            	switch (choice) 
	            	{
					case 1:
						System.out.println("Enter the Id that you want to display");
						int id=sc.nextInt();
						
						Students s=session.get(Students.class, id);
						
						if(s!=null)
						{
							 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
							 System.out.println(s.getStudentsId()+"\t\t"+s.getStudentsName()+"\t\t"+s.getStudentsAge()+"\t\t"+s.getStudentsClass()+"\t\t"+s.getStudentsPass());
						}
						break;
					case 2:
						System.out.println("Enter the name that you want to dispaly");
						String Name=sc.next();
						 
						List<Students> li=session.createQuery("from Students where StudentName=:Name").
								setParameter("Name", Name).getResultList();
						
						 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
						 
						 for(Students s2:li)
						 {
							 System.out.println(s2.getStudentsId()+"\t\t"+s2.getStudentsName()+"\t\t"+s2.getStudentsAge()+"\t\t"+s2.getStudentsClass()+"\t\t"+s2.getStudentsPass());
						 }
						
						break;
					case 3:
						System.out.println("Enter the Age that you want to display");
						int age=sc.nextInt();
						
						List<Students> li2=session.createQuery("from Students where StudentAge=:age").
								setParameter("age", age).getResultList();
						
						 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
						 
						 for(Students s2:li2)
						 {
							 System.out.println(s2.getStudentsId()+"\t\t"+s2.getStudentsName()+"\t\t"+s2.getStudentsAge()+"\t\t"+s2.getStudentsClass()+"\t\t"+s2.getStudentsPass());
						 }
						break;
					case 4:
						System.out.println("Enter the Class that you want to display");
						String Sclass=sc.next();
						
						List<Students> li3=session.createQuery("from Students where StudentClass=:Sclass").
								setParameter("Sclass", Sclass).getResultList();
						
						 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
						 
						 for(Students s2:li3)
						 {
							 System.out.println(s2.getStudentsId()+"\t\t"+s2.getStudentsName()+"\t\t"+s2.getStudentsAge()+"\t\t"+s2.getStudentsClass()+"\t\t"+s2.getStudentsPass());
						 }
						
						break;

					default:
						System.err.println("Wrong Input");
						break;
					}
	            
	        }
	}
	

	
}
