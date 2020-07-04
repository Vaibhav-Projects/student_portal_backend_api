package com.vaibhav.school.portal.utils;

import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.service.request.StudentRequest;

@Component
public class StudentUtils {

	public StudentRequest buildStudentRequest(Student student, String requestType) {
		StudentRequest studentRequest = new StudentRequest();
		studentRequest.setStudent(student);
		studentRequest.setRequestType(requestType);
		return studentRequest;
	}


}
