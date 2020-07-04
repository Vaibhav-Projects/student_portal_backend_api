package com.vaibhav.school.portal.business;

import com.vaibhav.school.portal.service.request.TeacherRequest;
import com.vaibhav.school.portal.service.response.TeacherResponse;

public interface TeacherBo {

	public TeacherResponse lookUpTeacher(TeacherRequest request);
}
