package com.Database.ExamportalProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Paper")
public class Papers 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaperID",length = 20)
	private int PaperId;
	@Column(name = "PaperName",length = 40)	
	private String PaperName;
	@Column(name = "PaperType",length = 40)	
	private String PaperType;
	@Column(name = "PaperSubject",length = 40)	
	private String PaperSubject;
	
	@OneToOne(mappedBy = "paper",cascade = CascadeType.PERSIST)
	private Teachers teachersId;

	public Papers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Papers(String paperName, String paperType, String paperSubject, Teachers teachersId) {
		super();
		PaperName = paperName;
		PaperType = paperType;
		PaperSubject = paperSubject;
		this.teachersId = teachersId;
	}

	public int getPaperId() {
		return PaperId;
	}

	public void setPaperId(int paperId) {
		PaperId = paperId;
	}

	public String getPaperName() {
		return PaperName;
	}

	public void setPaperName(String paperName) {
		PaperName = paperName;
	}

	public String getPaperType() {
		return PaperType;
	}

	public void setPaperType(String paperType) {
		PaperType = paperType;
	}

	public String getPaperSubject() {
		return PaperSubject;
	}

	public void setPaperSubject(String paperSubject) {
		PaperSubject = paperSubject;
	}

	public Teachers getTeachersId() {
		return teachersId;
	}

	public void setTeachersId(Teachers teachersId) {
		this.teachersId = teachersId;
	}
	
	
	
	
}
