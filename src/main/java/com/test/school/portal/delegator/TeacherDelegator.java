package com.test.school.portal.delegator;

import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.TeacherResponse;

public interface TeacherDelegator {

	public TeacherResponse processTeacher(TeacherRequest teacher);
}
