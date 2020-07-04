package com.vaibhav.school.portal.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaibhav.school.portal.entity.Teacher;

public class TeacherRequest {
	
	@JsonIgnore
	private Teacher teacher;
	private String requestType;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		return "TeacherRequest [teacher=" + teacher + ", requestType=" + requestType + "]";
	}

}
