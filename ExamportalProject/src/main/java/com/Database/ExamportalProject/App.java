package com.Database.ExamportalProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Dao.MarksDao;
import com.Database.ExamportalProject.Dao.PaperDao;
import com.Database.ExamportalProject.Dao.StudentsDao;
import com.Database.ExamportalProject.Dao.TeacherDao;
import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;
import com.Database.ExamportalProject.model.Students;
import com.Database.ExamportalProject.model.Teachers;
//import com.Database.ExamportalProject.Dao.PaperDao;
//import com.Database.ExamportalProject.Dao.StudentsDao;
//import com.Database.ExamportalProject.Dao.TeachersDao;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc = new Scanner(System.in);

	
	public void insertintoStudents_Marks()
	{
		char ans ;
		do
		{
			
			Students s = new Students();
			System.out.println("Enter students Name");
			s.setStudentsName(sc.next());
			System.out.println("Enter students age");
			s.setStudentsAge(sc.nextInt());
			System.out.println("Enter students Class");
			s.setStudentsClass(sc.next());
			System.out.println("Enter Students Password ");
			s.setStudentsPass(sc.next());
	    	
			Marks m = new Marks();
			
	    	System.out.println("Enter marks Score");
			m.setMarksScore(sc.next());
			System.out.println("Enter marks Remarks");
			m.setMarksRemark(sc.next());
			
	    	m.setStudentId(s);
	    	s.setMarks(m);
	
	    	MarksDao md = new MarksDao();
	    	md.insertMarkDetails(m);
	    	
	    	StudentsDao sd = new StudentsDao();
	    	sd.insertstudentsDetails(s);
			
			System.out.println("Do you want insert somwthing else (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');
	    	
	}
	
			public void insertintoTeachers_Paper()
			{

				char ans ;
				do
				{
					Teachers t = new Teachers();
					System.out.println("Enter Teachers Name");
					t.setTeacherName(sc.next());
					System.out.println("Enter Teachers Age");
					t.setTeacherAge(sc.nextInt());
					System.out.println("Enter Teacher Password");
					t.setTeacherPass(sc.next());
					
					Papers p = new Papers();
					System.out.println("Enter paper Name (Semseter/Unittest)");
					p.setPaperName(sc.next());
					System.out.println("Enter paper Type");
					p.setPaperType(sc.next());
					System.out.println("Enter paper Subject ");
					p.setPaperSubject(sc.next());
					
					p.setTeachersId(t);
					t.setPaper(p);
					
					PaperDao pd = new PaperDao();
					pd.insertPaperDetails(p);
					
					TeacherDao td = new TeacherDao();
					td.insertTeacherDetails(t);
					
					System.out.println("Do you want insert somwthing else (Y/N)");
					ans=sc.next().charAt(0);
					
				}
				while(ans=='y' || ans=='Y');	
			}
	
	
	public void delete ()
	{
		
		char ans ;
		do
		{
			System.out.println("Choose from below to delete an operation from");
			System.out.println("1) To delete a Student");
			System.out.println("2) To delete a Marks");
			System.out.println("3) To delete a Paper");
			System.out.println("4) To delete a Teachers");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentsDao sd = new StudentsDao();
				System.out.println("Enter a id to delete");
				int sid=sc.nextInt();
				sd.deleteStudentById(sid);
				break;
			case 2:
				MarksDao md = new MarksDao();
				System.out.println("Enter a id to delete");
				int mid=sc.nextInt();
				md.deleteStudentById(mid);
				break;
			case 3:
				PaperDao pd = new PaperDao();
				System.out.println("Enter a id to delete");
				int pid=sc.nextInt();
				pd.deleteStudentById(pid);
				break;
			case 4:
				TeacherDao td = new TeacherDao();
				System.out.println("Enter a id to delete");
				int tid=sc.nextInt();
				td.deleteStudentById(tid);
				break;

			default:
				System.out.println("Wrong input ");
				break;
			}
			
			System.out.println("Do you want delete something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');	
	}
		
	
	
	public void update()
	{
		
		
		char ans ;
		do
		{
			
			System.out.println("Choose from below to delete an operation from");
			System.out.println("1) To Update a Student");
			System.out.println("2) To Update a Marks");
			System.out.println("3) To Update a Paper");
			System.out.println("4) To Update a Teachers");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentsDao sd= new StudentsDao();
				System.out.println("Enter the id that you want to update");
				int id1=sc.nextInt();
				sd.updateStudents(id1);
				break;
			case 2:
				MarksDao md= new MarksDao();
				System.out.println("Enter the id that you want to update");
				int id2=sc.nextInt();
				md.updateMarks(id2);
				break;
			case 3:
				PaperDao pd= new PaperDao();
				System.out.println("Enter the id that you want to update");
				int id3=sc.nextInt();
				pd.updatePapers(id3);
				break;
			case 4:
				TeacherDao td = new TeacherDao();
				System.out.println("Enter the id that you want to update");
				int id=sc.nextInt();
				td.updateTeachers(id);
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}		
			System.out.println("Do you want Update Something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');	
		
	}
	
	
	
	public void display()
	{
		char ans ;
		do
		{
			System.out.println("Choose from below to display an operation from");
			System.out.println("1) To Display the Student Table");
			System.out.println("2) To DIsplay the Marks Table");
			System.out.println("3) To Display the Paper Table");
			System.out.println("4) To Display the Teachers Table");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentsDao sd= new StudentsDao();
				sd.displayStudents();
				break;
			case 2:
				MarksDao md = new MarksDao();
				md.displayMarks();
				break;
			case 3:
				PaperDao pd = new PaperDao();
				pd.displayPaper();
				break;
			case 4:
				TeacherDao td=new TeacherDao();
				td.displayTeachers();
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}
			
			
			System.out.println("Do you want Display something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');
	}
	
	
	
	
	
	public void customize() 
	{
		char ans ;
		do
		{
			System.out.println("Choose from below to Display customize Table From ");
			System.out.println("1) Student Table");
			System.out.println("2) Teachers Table");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentsDao sd= new StudentsDao();
				sd.customizeStudentsTable();
				break;
			case 2:
				TeacherDao td=new TeacherDao();
				
				td.customizeteachersTable();
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}
			
			
			System.out.println("Do you want Display Something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');
	}
	
	
	
	
	public void operation() 
	{
		
		char ans ;
		do
		{	
			System.out.println("Choose From Below");
			System.out.println("1) To insert the new data");
			System.out.println("2) To delete the data");
			System.out.println("3) To Update the new data");
			System.out.println("4) To display the Entire Table");
			System.out.println("5) To display the Customize Table");
			int choice=sc.nextInt();
			
			switch (choice) 
			{
			case 1:
				System.out.println("\n1)insert into Students and marks table");
				System.out.println("2)insert into teachers and paper table");
				int choose=sc.nextInt();
				switch (choose) 
				{
				case 1:
					insertintoStudents_Marks();
					break;
				case 2:
					insertintoTeachers_Paper();
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				display();
				break;
			case 5:
				customize();
				break;

			default:
				break;
			}
			System.out.println("Do you want perform anything else from Main Menu (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');
		
	}
			

	
    public static void main( String[] args )
    {
    	App a = new App();
    	System.out.println("********Welcome to the ExamPortal********");
    	a.operation();
    		
    }
    
}
