package com.vaibhav.school.portal.service.response;

import java.util.List;

import com.vaibhav.school.portal.vo.SubjectVO;

public class SubjectResponse {

	private List<SubjectVO> subjectsList;

	public List<SubjectVO> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<SubjectVO> subjectsList) {
		this.subjectsList = subjectsList;
	}

}
