package com.test.school.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Student_info")
public class TeacherStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Teacher_Student_id")
	private int teacherStudentId;
	@Column(name = "Teacher_id")
	private int teacherId;
	@Column(name = "Student_id")
	private int studentId;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTeacherStudentId() {
		return teacherStudentId;
	}

	public void setTeacherStudentId(int teacherStudentId) {
		this.teacherStudentId = teacherStudentId;
	}
}
