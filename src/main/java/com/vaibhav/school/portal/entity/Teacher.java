package com.vaibhav.school.portal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_info")
public class Teacher {
	@Id
	@Column(name = "Teacher_id")
	int teacherId;
	@Column(name = "Teacher_name")
	String teacherName;
	@Column(name = "Teacher_phone")
	String teacherPhone;
	@Column(name = "Teacher_address")
	String teacherAddress;
	@ManyToMany
	@JoinTable(name = "Teacher_Subject_info", joinColumns = @JoinColumn(name = "Teacher_id"), inverseJoinColumns = @JoinColumn(name = "Subject_id"))
	List<Subject> subjectsList;
	@ManyToMany
	@JoinTable(name = "Teacher_Student_info", joinColumns = @JoinColumn(name = "Teacher_id"), inverseJoinColumns = @JoinColumn(name = "Student_id"))
	List<Student> studentList;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public List<Subject> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<Subject> subjectsList) {
		this.subjectsList = subjectsList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Teacher() {
		super();
	}

	public Teacher(int teacherId, String teacherName, String teacherPhone, String teacherAddress,
			List<Subject> subjectsList, List<Student> studentList) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPhone = teacherPhone;
		this.teacherAddress = teacherAddress;
		this.subjectsList = subjectsList;
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherPhone=" + teacherPhone
				+ ", teacherAddress=" + teacherAddress + ", subjectsList=" + subjectsList + ", studentList="
				+ studentList + "]";
	}
}
