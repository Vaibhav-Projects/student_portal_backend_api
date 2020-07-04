package com.vaibhav.school.portal.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vaibhav.command.Commander;
import com.vaibhav.school.portal.business.TeacherBo;
import com.vaibhav.school.portal.service.request.TeacherRequest;
import com.vaibhav.school.portal.service.response.TeacherResponse;

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
