package com.vaibhav.school.portal.business;

import com.vaibhav.school.portal.service.request.StudentRequest;
import com.vaibhav.school.portal.service.response.StudentResponse;

public interface StudentBo {

	public StudentResponse lookUpStudent(StudentRequest request);
}
