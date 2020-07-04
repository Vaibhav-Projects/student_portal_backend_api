package com.vaibhav.school.portal.service.response;

import java.util.List;

import com.vaibhav.school.portal.vo.StudentVO;

public class StudentResponse {

	private List<StudentVO> studentsList;

	public List<StudentVO> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<StudentVO> studentsList) {
		this.studentsList = studentsList;
	}

}
