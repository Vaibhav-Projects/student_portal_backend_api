package com.test.school.portal.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.school.portal.entity.Student;

public class StudentRequest {

	@JsonIgnore
	private Student student;
	private String requestType;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		return "StudentRequest [student=" + student + ", requestType=" + requestType + "]";
	}
}
