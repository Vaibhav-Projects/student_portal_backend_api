package com.test.school.portal.business;

import com.test.school.portal.service.request.SubjectRequest;
import com.test.school.portal.service.response.SubjectResponse;

public interface SubjectBo {

	public SubjectResponse lookUpSubject(SubjectRequest request);
}
