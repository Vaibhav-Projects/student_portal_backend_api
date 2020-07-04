package com.test.school.portal.service.response;

import java.util.List;

import com.test.school.portal.vo.SubjectVO;

public class SubjectResponse {

	private List<SubjectVO> subjectsList;

	public List<SubjectVO> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<SubjectVO> subjectsList) {
		this.subjectsList = subjectsList;
	}

}
