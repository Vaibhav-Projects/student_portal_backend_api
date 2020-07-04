package com.vaibhav.school.portal.delegator;

import com.vaibhav.school.portal.service.request.SubjectRequest;
import com.vaibhav.school.portal.service.response.SubjectResponse;

public interface SubjectDelegator {

	public SubjectResponse processSubject(SubjectRequest subject);
}
