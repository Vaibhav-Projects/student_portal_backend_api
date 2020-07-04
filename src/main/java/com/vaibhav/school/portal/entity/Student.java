package com.vaibhav.school.portal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Student_info")
@XmlRootElement
public class Student {

	@Id
	@Column(name = "Student_id")
	int studentId;
	@Column(name = "Student_name")
	String studentName;
	@Column(name = "Student_father_name")
	String studentFatherName;
	@Column(name = "Student_mother_name")
	String studentMotherName;
	@Column(name = "Student_class")
	String studentClass;
	@Column(name = "Student_section")
	String studentSection;
	@Column(name = "Student_phone")
	String studentPhone;
	@Column(name = "Student_address")
	String studentAddress;
	@ManyToMany
	@JoinTable(name = "Student_Subject_info", joinColumns = @JoinColumn(name = "Student_id"), inverseJoinColumns = @JoinColumn(name = "Subject_id"))
	List<Subject> subjectList;
	@ManyToMany(mappedBy = "studentList",cascade = CascadeType.REMOVE)
	List<Teacher> teacherList;

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public Student() {

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentFatherName() {
		return studentFatherName;
	}

	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}

	public String getStudentMotherName() {
		return studentMotherName;
	}

	public void setStudentMotherName(String studentMotherName) {
		this.studentMotherName = studentMotherName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Student(int studentId, String studentName, String studentFatherName, String studentMotherName,
			String studentClass, String studentSection, String studentPhone, String studentAddress,
			List<Subject> subjectList, List<Teacher> teacherList) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentFatherName = studentFatherName;
		this.studentMotherName = studentMotherName;
		this.studentClass = studentClass;
		this.studentSection = studentSection;
		this.studentPhone = studentPhone;
		this.studentAddress = studentAddress;
		this.subjectList = subjectList;
		this.teacherList = teacherList;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentFatherName="
				+ studentFatherName + ", studentMotherName=" + studentMotherName + ", studentClass=" + studentClass
				+ ", studentSection=" + studentSection + ", studentPhone=" + studentPhone + ", studentAddress="
				+ studentAddress + "]";
	}

}
