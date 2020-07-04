package com.test.school.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Subject_info")
public class StudentSubject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_Subject_id")
	private int studentSubjectId;
	@Column(name = "Student_id")
	private int studentId;
	@Column(name = "Subject_id")
	private int subjectId;

	public int getStudentSubjectId() {
		return studentSubjectId;
	}

	public void setStudentSubjectId(int studentSubjectId) {
		this.studentSubjectId = studentSubjectId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

}
