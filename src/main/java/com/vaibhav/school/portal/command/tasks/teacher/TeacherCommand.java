package com.vaibhav.school.portal.command.tasks.teacher;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.command.Command;
import com.vaibhav.school.portal.delegator.TeacherDelegator;
import com.vaibhav.school.portal.service.request.TeacherRequest;
import com.vaibhav.school.portal.service.response.TeacherResponse;

public class TeacherCommand implements Command<TeacherRequest, TeacherResponse> {

	@Autowired
	private TeacherDelegator teacherDelegator;

	@Override
	public TeacherResponse process(TeacherRequest request) {
		return teacherDelegator.processTeacher(request);
	}

	@Override
	public boolean isProcessor() {
		return true;
	}

}
