package com.test.school.portal.utils;

import org.springframework.stereotype.Component;

import com.test.school.portal.entity.Subject;
import com.test.school.portal.service.request.SubjectRequest;

@Component
public class SubjectUtils {

	public SubjectRequest buildSubjectRequest(Subject subject, String requestType) {
		SubjectRequest subjectRequest = new SubjectRequest();
		subjectRequest.setSubject(subject);
		subjectRequest.setRequestType(requestType);
		return subjectRequest;
	}

}
