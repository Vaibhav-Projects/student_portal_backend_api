package com.test.school.portal.utils;

import org.springframework.stereotype.Component;

import com.test.school.portal.entity.Student;
import com.test.school.portal.service.request.StudentRequest;

@Component
public class StudentUtils {

	public StudentRequest buildStudentRequest(Student student, String requestType) {
		StudentRequest studentRequest = new StudentRequest();
		studentRequest.setStudent(student);
		studentRequest.setRequestType(requestType);
		return studentRequest;
	}


}
