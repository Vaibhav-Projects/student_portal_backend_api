package com.test.school.portal.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.command.Commander;
import com.test.school.portal.business.SubjectBo;
import com.test.school.portal.service.request.SubjectRequest;
import com.test.school.portal.service.response.SubjectResponse;

@Component
public class SubjectBoImpl implements SubjectBo {

	@Autowired
	@Qualifier("subjectCommander")
	public Commander<SubjectRequest, SubjectResponse> subjectCommander;

	@Override
	public SubjectResponse lookUpSubject(SubjectRequest request) {
		SubjectResponse response = subjectCommander.issueCommand(request);
		return response;
	}
}
