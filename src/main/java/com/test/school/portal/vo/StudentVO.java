package com.test.school.portal.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.test.school.portal.entity.Subject;
import com.test.school.portal.entity.Teacher;

@JsonInclude(Include.NON_NULL)
public class StudentVO {

	int studentId;
	String studentName;
	String studentFatherName;
	String studentMotherName;
	String studentClass;
	String studentSection;
	String studentPhone;
	String studentAddress;
	List<SubjectVO> subjectVOList;
	List<TeacherVO> teacherVOList;

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

	public List<SubjectVO> getSubjectVOList() {
		return subjectVOList;
	}

	public void setSubjectVOList(List<Subject> subjectList) {
		this.subjectVOList = new ArrayList<>();
		if (subjectList == null)
			return;
		for (Subject subject : subjectList) {
			SubjectVO subjectVO = new SubjectVO();
			subjectVO.setSubjectId(subject.getSubjectId());
			subjectVO.setSubjectName(subject.getSubjectName());
			subjectVOList.add(subjectVO);
		}
	}

	public List<TeacherVO> getTeacherVOList() {
		return teacherVOList;
	}

	public void setTeacherVOList(List<Teacher> teacherList) {
		if (teacherList == null)
			return;
		this.teacherVOList = new ArrayList<>();
		for (Teacher teacher : teacherList) {
			TeacherVO teacherVO = new TeacherVO();
			teacherVO.setTeacherAddress(teacher.getTeacherAddress());
			teacherVO.setTeacherId(teacher.getTeacherId());
			teacherVO.setTeacherName(teacher.getTeacherName());
			teacherVO.setTeacherPhone(teacher.getTeacherPhone());
			teacherVOList.add(teacherVO);
		}
	}

	@Override
	public String toString() {
		return "StudentVO [studentId=" + studentId + ", studentName=" + studentName + ", studentFatherName="
				+ studentFatherName + ", studentMotherName=" + studentMotherName + ", studentClass=" + studentClass
				+ ", studentSection=" + studentSection + ", studentPhone=" + studentPhone + ", studentAddress="
				+ studentAddress + ", subjectVOList=" + subjectVOList + ", teacherVOList=" + teacherVOList + "]";
	}

}
