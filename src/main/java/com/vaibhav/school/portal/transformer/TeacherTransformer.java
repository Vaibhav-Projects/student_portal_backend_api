package com.vaibhav.school.portal.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.entity.Teacher;
import com.vaibhav.school.portal.service.response.TeacherResponse;
import com.vaibhav.school.portal.vo.TeacherVO;

@Component
public class TeacherTransformer {

	TeacherResponse teacherResponse = new TeacherResponse();

	public TeacherResponse responseTransformer(List<Teacher> teacherList) {

		List<TeacherVO> teacherVOList = new ArrayList<TeacherVO>();
		for (Teacher teacher : teacherList) {
			TeacherVO teacherVO = new TeacherVO();
			teacherVO.setStudentVOList(teacher.getStudentList());
			teacherVO.setSubjectVOList(teacher.getSubjectsList());
			teacherVO.setTeacherAddress(teacher.getTeacherAddress());
			teacherVO.setTeacherId(teacher.getTeacherId());
			teacherVO.setTeacherName(teacher.getTeacherName());
			teacherVO.setTeacherPhone(teacher.getTeacherPhone());
			teacherVOList.add(teacherVO);
		}
		teacherResponse.setTeachersList(teacherVOList);
		return teacherResponse;
	}
}
