package com.vaibhav.school.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Subject_info")
public class SubjectTeacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Teacher_Subject_id")
	private int teacherSubjectId;
	@Column(name = "Teacher_id")
	private int teacherId;
	@Column(name = "Subject_id")
	private int subjectId;

	public int getTeacherSubjectId() {
		return teacherSubjectId;
	}

	public void setTeacherSubjectId(int teacherSubjectId) {
		this.teacherSubjectId = teacherSubjectId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
}
