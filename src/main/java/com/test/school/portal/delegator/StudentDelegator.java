package com.test.school.portal.delegator;

import com.test.school.portal.service.request.StudentRequest;
import com.test.school.portal.service.response.StudentResponse;

public interface StudentDelegator {

	public StudentResponse processStudent(StudentRequest student);
}
