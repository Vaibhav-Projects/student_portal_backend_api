package com.test.school.portal.business;

import com.test.school.portal.service.request.StudentRequest;
import com.test.school.portal.service.response.StudentResponse;

public interface StudentBo {

	public StudentResponse lookUpStudent(StudentRequest request);
}
