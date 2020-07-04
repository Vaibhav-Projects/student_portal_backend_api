package com.test.school.portal.command.tasks.teacher;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.command.Command;
import com.test.school.portal.delegator.TeacherDelegator;
import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.TeacherResponse;

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
