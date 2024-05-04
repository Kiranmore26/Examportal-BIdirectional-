package com.Database.ExamportalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Teachers 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TeacherId",length = 20)
	private int TeacherId;
	@Column(name = "TeacherName",length = 40)
	private String TeacherName;
	@Column(name = "TeacherAge",length = 10)
	private int TeacherAge;
	@Column(name = "TeacherPass",length = 50)
	private String TeacherPass;
	
	
	@OneToOne
	@JoinColumn(name = "Paper")
	private Papers paper;


	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Teachers(String teacherName, int teacherAge, String teacherPass, Papers paper) {
		super();
		TeacherName = teacherName;
		TeacherAge = teacherAge;
		TeacherPass = teacherPass;
		this.paper = paper;
	}


	public int getTeacherId() {
		return TeacherId;
	}


	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}


	public String getTeacherName() {
		return TeacherName;
	}


	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}


	public int getTeacherAge() {
		return TeacherAge;
	}


	public void setTeacherAge(int teacherAge) {
		TeacherAge = teacherAge;
	}


	public String getTeacherPass() {
		return TeacherPass;
	}


	public void setTeacherPass(String teacherPass) {
		TeacherPass = teacherPass;
	}


	public Papers getPaper() {
		return paper;
	}


	public void setPaper(Papers paper) {
		this.paper = paper;
	}


	
}
