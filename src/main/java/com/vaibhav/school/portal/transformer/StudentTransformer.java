package com.vaibhav.school.portal.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.service.response.StudentResponse;
import com.vaibhav.school.portal.vo.StudentVO;

@Component
public class StudentTransformer {

	StudentResponse studentResponse = new StudentResponse();

	public StudentResponse responseTransformer(List<Student> studentList) {
		List<StudentVO> studentVOList = new ArrayList<StudentVO>();
		for (Student student : studentList) {
			StudentVO studentVO = new StudentVO();
			studentVO.setStudentId(student.getStudentId());
			studentVO.setStudentName(student.getStudentName());
			studentVO.setStudentFatherName(student.getStudentFatherName());
			studentVO.setStudentMotherName(student.getStudentMotherName());
			studentVO.setStudentClass(student.getStudentClass());
			studentVO.setStudentAddress(student.getStudentAddress());
			studentVO.setStudentPhone(student.getStudentPhone());
			studentVO.setSubjectVOList(student.getSubjectList());
			studentVO.setTeacherVOList(student.getTeacherList());
			studentVO.setStudentSection(student.getStudentSection());
			studentVOList.add(studentVO);
		}
		studentResponse.setStudentsList(studentVOList);
		return studentResponse;
	}
}
