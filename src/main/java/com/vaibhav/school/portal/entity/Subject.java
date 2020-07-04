package com.vaibhav.school.portal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subject_info")
public class Subject {

	@Id
	@Column(name = "Subject_id")
	int subjectId;
	@Column(name = "Subject_name")
	String subjectName;
	@ManyToMany(mappedBy = "subjectList",cascade = CascadeType.REMOVE)
	List<Student> studentList;
	@ManyToMany(mappedBy = "subjectsList",cascade = CascadeType.REMOVE)
	List<Teacher> teacherList;

	public List<Student> getStudentList() {
		return studentList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Subject() {
		super();
	}

	public Subject(int subjectId, String subjectName, List<Student> studentList, List<Teacher> teacherList) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.studentList = studentList;
		this.teacherList = teacherList;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", studentList=" + studentList
				+ ", teacherList=" + teacherList + "]";
	}
}
