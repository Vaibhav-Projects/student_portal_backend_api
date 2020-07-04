package com.vaibhav.school.portal.business;

import com.vaibhav.school.portal.service.request.SubjectRequest;
import com.vaibhav.school.portal.service.response.SubjectResponse;

public interface SubjectBo {

	public SubjectResponse lookUpSubject(SubjectRequest request);
}
