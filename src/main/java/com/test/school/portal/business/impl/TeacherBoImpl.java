package com.test.school.portal.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.command.Commander;
import com.test.school.portal.business.TeacherBo;
import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.TeacherResponse;

@Component
public class TeacherBoImpl implements TeacherBo {

	@Autowired
	@Qualifier("teacherCommander")
	public Commander<TeacherRequest, TeacherResponse> teacherCommander;

	@Override
	public TeacherResponse lookUpTeacher(TeacherRequest request) {
		TeacherResponse response = teacherCommander.issueCommand(request);
		return response;
	}
}
