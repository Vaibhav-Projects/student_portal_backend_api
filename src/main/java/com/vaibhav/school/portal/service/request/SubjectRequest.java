package com.vaibhav.school.portal.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaibhav.school.portal.entity.Subject;

public class SubjectRequest {

	@JsonIgnore
	private Subject subject;
	private String requestType;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		return "SubjectRequest [subject=" + subject + ", requestType=" + requestType + "]";
	}

}
