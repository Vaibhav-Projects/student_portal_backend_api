package com.test.school.portal.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.school.portal.entity.Subject;
import com.test.school.portal.service.response.SubjectResponse;
import com.test.school.portal.vo.SubjectVO;

@Component
public class SubjectTransformer {

	SubjectResponse subjectResponse = new SubjectResponse();

	public SubjectResponse responseTransformer(List<Subject> subjectList) {
		List<SubjectVO> subjectVOList = new ArrayList<SubjectVO>();
		for (Subject subject : subjectList) {
			SubjectVO subjectVO = new SubjectVO();
			subjectVO.setStudentVOList(subject.getStudentList());
			subjectVO.setSubjectName(subject.getSubjectName());
			subjectVO.setSubjectId(subject.getSubjectId());
			subjectVO.setTeacherVOList(subject.getTeacherList());
			subjectVOList.add(subjectVO);
		}
		subjectResponse.setSubjectsList(subjectVOList);
		return subjectResponse;
	}
}
