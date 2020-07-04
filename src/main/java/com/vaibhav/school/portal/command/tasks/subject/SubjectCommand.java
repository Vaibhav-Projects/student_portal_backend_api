package com.vaibhav.school.portal.command.tasks.subject;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.command.Command;
import com.vaibhav.school.portal.delegator.SubjectDelegator;
import com.vaibhav.school.portal.service.request.SubjectRequest;
import com.vaibhav.school.portal.service.response.SubjectResponse;

public class SubjectCommand implements Command<SubjectRequest, SubjectResponse> {

	@Autowired
	private SubjectDelegator subjectDelegator;

	@Override
	public SubjectResponse process(SubjectRequest request) {
		return subjectDelegator.processSubject(request);
	}

	@Override
	public boolean isProcessor() {
		return true;
	}
}
