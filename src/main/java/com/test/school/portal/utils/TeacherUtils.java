package com.test.school.portal.utils;

import org.springframework.stereotype.Component;

import com.test.school.portal.entity.Teacher;
import com.test.school.portal.service.request.TeacherRequest;

@Component
public class TeacherUtils {

	public TeacherRequest buildTeacherRequest(Teacher teacher, String requestType) {
		TeacherRequest teacherRequest = new TeacherRequest();
		teacherRequest.setTeacher(teacher);
		teacherRequest.setRequestType(requestType);
		return teacherRequest;
	}
}
