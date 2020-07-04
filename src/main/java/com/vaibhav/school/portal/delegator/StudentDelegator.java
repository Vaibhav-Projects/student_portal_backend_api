package com.vaibhav.school.portal.delegator;

import com.vaibhav.school.portal.service.request.StudentRequest;
import com.vaibhav.school.portal.service.response.StudentResponse;

public interface StudentDelegator {

	public StudentResponse processStudent(StudentRequest student);
}
