package com.vaibhav.school.portal.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.entity.Teacher;

@JsonInclude(Include.NON_NULL)
public class SubjectVO {

	int subjectId;
	String subjectName;
	List<StudentVO> studentVOList;
	List<TeacherVO> teacherVOList;

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
		return "SubjectVO [subjectId=" + subjectId + ", subjectName=" + subjectName + ", studentVOList=" + studentVOList
				+ ", teacherVOList=" + teacherVOList + "]";
	}

}
