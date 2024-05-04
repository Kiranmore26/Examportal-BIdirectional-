package com.Database.ExamportalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Students 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StudentId",length = 20)
	private int StudentsId;
	@Column(name = "StudentName",length = 40)
	private String StudentsName;
	@Column(name = "StudentAge",length = 20)
	private int StudentsAge;
	@Column(name = "StudentClass",length = 20)
	private String StudentsClass;
	@Column(name = "StudentPassword",length = 20)
	private String StudentsPass;
	
	@OneToOne
	@JoinColumn(name = "MarksId")
	private Marks marks;

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(String studentsName, int studentsAge, String studentsClass, String studentsPass) {
		super();
		StudentsName = studentsName;
		StudentsAge = studentsAge;
		StudentsClass = studentsClass;
		StudentsPass = studentsPass;
		
	}

	public int getStudentsId() {
		return StudentsId;
	}

	public void setStudentsId(int studentsId) {
		StudentsId = studentsId;
	}

	public String getStudentsName() {
		return StudentsName;
	}

	public void setStudentsName(String studentsName) {
		StudentsName = studentsName;
	}

	public int getStudentsAge() {
		return StudentsAge;
	}

	public void setStudentsAge(int studentsAge) {
		StudentsAge = studentsAge;
	}

	public String getStudentsClass() {
		return StudentsClass;
	}

	public void setStudentsClass(String studentsClass) {
		StudentsClass = studentsClass;
	}

	public String getStudentsPass() {
		return StudentsPass;
	}

	public void setStudentsPass(String studentsPass) {
		StudentsPass = studentsPass;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	
	
	
	
}
