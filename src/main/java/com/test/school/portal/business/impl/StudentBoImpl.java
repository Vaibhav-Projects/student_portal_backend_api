
package com.test.school.portal.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.command.Commander;
import com.test.school.portal.business.StudentBo;
import com.test.school.portal.service.request.StudentRequest;
import com.test.school.portal.service.response.StudentResponse;

@Component
public class StudentBoImpl implements StudentBo {

	@Autowired
	@Qualifier("studentCommander")
	public Commander<StudentRequest, StudentResponse> studentCommander;

	@Override
	public StudentResponse lookUpStudent(StudentRequest request) {
		StudentResponse response = studentCommander.issueCommand(request);
		return response;
	}
}
