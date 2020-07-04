package com.vaibhav.school.portal.delegator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.dao.impl.StudentDAOImpl;
import com.vaibhav.school.portal.delegator.StudentDelegator;
import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.service.request.StudentRequest;
import com.vaibhav.school.portal.service.response.StudentResponse;
import com.vaibhav.school.portal.transformer.StudentTransformer;

@Component
public class StudentDelegatorImpl implements StudentDelegator {

	@Autowired
	StudentDAOImpl studentDAO;
	@Autowired
	StudentTransformer studentTransformer;

	public StudentResponse processStudent(StudentRequest student) {
		if (student.getRequestType() == "update") {
			Student studentObj = new Student();
			List<Student> studentList = new ArrayList<>();
			studentObj = studentDAO.updateStudent(student.getStudent());
			studentList.add(studentObj);
			return studentTransformer.responseTransformer(studentList);
		}
		if (student.getRequestType() == "getAll") {
			List<Student> studentList = new ArrayList<>();
			studentList = studentDAO.getAllStudents();
			return studentTransformer.responseTransformer(studentList);
		}
		if (student.getRequestType() == "getById") {
			List<Student> studentList = new ArrayList<Student>();
			Student studentObj = new Student();
			studentObj = studentDAO.getStudentById(student.getStudent().getStudentId());
			studentList.add(studentObj);
			return studentTransformer.responseTransformer(studentList);
		}
		if (student.getRequestType() == "getByClassAndSection") {
			List<Student> studentList = new ArrayList<Student>();
			studentList = studentDAO.getStudentsByClassAndSection(student.getStudent().getStudentClass(),
					student.getStudent().getStudentSection());
			return studentTransformer.responseTransformer(studentList);

		}
		if (student.getRequestType() == "getByClass") {
			List<Student> studentList = new ArrayList<Student>();
			studentList = studentDAO.getStudentsByClass(student.getStudent().getStudentClass());
			return studentTransformer.responseTransformer(studentList);
		}
		if (student.getRequestType() == "delete") {
			Student studentObj = new Student();
			List<Student> studentList = new ArrayList<Student>();
			studentObj = studentDAO.deleteStudentById(student.getStudent().getStudentId());
			studentList.add(studentObj);
			return studentTransformer.responseTransformer(studentList);
		}
		if (student.getRequestType() == "insert") {
			Student studentObj = new Student();
			List<Student> studentList = new ArrayList<Student>();
			studentObj = studentDAO.insertStudent(student.getStudent());
			studentList.add(studentObj);
			return studentTransformer.responseTransformer(studentList);

		}
		return null;
	}
}
