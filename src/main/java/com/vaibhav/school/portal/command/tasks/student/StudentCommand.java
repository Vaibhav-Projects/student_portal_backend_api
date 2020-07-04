package com.vaibhav.school.portal.command.tasks.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.command.Command;
import com.vaibhav.school.portal.delegator.impl.StudentDelegatorImpl;
import com.vaibhav.school.portal.service.request.StudentRequest;
import com.vaibhav.school.portal.service.response.StudentResponse;

public class StudentCommand implements Command<StudentRequest, StudentResponse> {

	@Autowired
	StudentDelegatorImpl studentDelegator;

	@Override
	public StudentResponse process(StudentRequest request) {
		return studentDelegator.processStudent(request);
	}

	@Override
	public boolean isProcessor() {
		return true;
	}
}
