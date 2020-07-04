package com.test.school.portal.business;

import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.TeacherResponse;

public interface TeacherBo {

	public TeacherResponse lookUpTeacher(TeacherRequest request);
}
