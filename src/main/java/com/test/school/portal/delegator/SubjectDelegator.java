package com.test.school.portal.delegator;

import com.test.school.portal.service.request.SubjectRequest;
import com.test.school.portal.service.response.SubjectResponse;

public interface SubjectDelegator {

	public SubjectResponse processSubject(SubjectRequest subject);
}
