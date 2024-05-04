package com.Database.ExamportalProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Marks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MarksId",length = 20)
	private int MarksId;
	@Column(name = "MarksScore",length = 30)
	private String MarksScore;
	@Column(name = "MarksRemark",length = 50)
	private String MarksRemark;
	
	
	@OneToOne(mappedBy = "marks",cascade = CascadeType.PERSIST)
	private Students studentId;
	
	
	
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Marks(String marksScore, String marksRemark) {
		super();
		MarksScore = marksScore;
		MarksRemark = marksRemark;
	
	}



	public int getMarksId() {
		return MarksId;
	}



	public void setMarksId(int marksId) {
		MarksId = marksId;
	}



	public String getMarksScore() {
		return MarksScore;
	}



	public void setMarksScore(String marksScore) {
		MarksScore = marksScore;
	}



	public String getMarksRemark() {
		return MarksRemark;
	}



	public void setMarksRemark(String marksRemark) {
		MarksRemark = marksRemark;
	}



	public Students getStudentId() {
		return studentId;
	}



	public void setStudentId(Students studentId) {
		this.studentId = studentId;
	}

	
}
