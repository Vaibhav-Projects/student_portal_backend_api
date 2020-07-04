package com.test.school.portal.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.test.school.portal.entity.Student;
import com.test.school.portal.entity.Subject;

@JsonInclude(Include.NON_NULL)
public class TeacherVO {

	int teacherId;
	String teacherName;
	String teacherPhone;
	String teacherAddress;
	List<SubjectVO> subjectVOList;
	List<StudentVO> studentVOList;

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

	public List<SubjectVO> getSubjectVOList() {
		return subjectVOList;
	}

	public void setSubjectVOList(List<Subject> subjectList) {
		if (subjectList == null)
			return;
		this.subjectVOList = new ArrayList<>();
		for (Subject subject : subjectList) {
			SubjectVO subjectVO = new SubjectVO();
			subjectVO.setStudentVOList(null);
			subjectVO.setSubjectId(subject.getSubjectId());
			subjectVO.setSubjectName(subject.getSubjectName());
			subjectVO.setTeacherVOList(null);
			subjectVOList.add(subjectVO);
		}
	}

	public List<StudentVO> getStudentVOList() {
		return studentVOList;
	}

	public void setStudentVOList(List<Student> studentList) {
		if (studentList == null)
			return;
		this.studentVOList = new ArrayList<>();
		for (Student student : studentList) {
			StudentVO studentVO = new StudentVO();
			studentVO.setStudentAddress(student.getStudentAddress());
			studentVO.setStudentClass(student.getStudentClass());
			studentVO.setStudentFatherName(student.getStudentFatherName());
			studentVO.setStudentId(student.getStudentId());
			studentVO.setStudentMotherName(student.getStudentMotherName());
			studentVO.setStudentName(student.getStudentName());
			studentVO.setStudentPhone(student.getStudentPhone());
			studentVO.setStudentSection(student.getStudentSection());
			studentVOList.add(studentVO);
		}
	}

	@Override
	public String toString() {
		return "TeacherVO [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherPhone=" + teacherPhone
				+ ", teacherAddress=" + teacherAddress + ", subjectVOList=" + subjectVOList + ", studentVOList="
				+ studentVOList + "]";
	}

}
