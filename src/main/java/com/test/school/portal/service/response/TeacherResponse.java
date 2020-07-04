package com.test.school.portal.service.response;

import java.util.List;

import com.test.school.portal.vo.TeacherVO;

public class TeacherResponse {

	private List<TeacherVO> teachersList;

	public List<TeacherVO> getTeachersList() {
		return teachersList;
	}

	public void setTeachersList(List<TeacherVO> teachersList) {
		this.teachersList = teachersList;
	}

}
