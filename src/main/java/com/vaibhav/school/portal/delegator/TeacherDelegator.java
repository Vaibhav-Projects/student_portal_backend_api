package com.vaibhav.school.portal.delegator;

import com.vaibhav.school.portal.service.request.TeacherRequest;
import com.vaibhav.school.portal.service.response.TeacherResponse;

public interface TeacherDelegator {

	public TeacherResponse processTeacher(TeacherRequest teacher);
}
