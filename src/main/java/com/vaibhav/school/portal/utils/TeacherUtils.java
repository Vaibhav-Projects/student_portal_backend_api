package com.vaibhav.school.portal.utils;

import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.entity.Teacher;
import com.vaibhav.school.portal.service.request.TeacherRequest;

@Component
public class TeacherUtils {

	public TeacherRequest buildTeacherRequest(Teacher teacher, String requestType) {
		TeacherRequest teacherRequest = new TeacherRequest();
		teacherRequest.setTeacher(teacher);
		teacherRequest.setRequestType(requestType);
		return teacherRequest;
	}
}
