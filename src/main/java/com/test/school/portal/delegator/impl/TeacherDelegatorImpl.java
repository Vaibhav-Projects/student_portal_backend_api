package com.test.school.portal.delegator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.school.portal.dao.impl.TeacherDAOImpl;
import com.test.school.portal.delegator.TeacherDelegator;
import com.test.school.portal.entity.Teacher;
import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.TeacherResponse;
import com.test.school.portal.transformer.TeacherTransformer;

@Component
public class TeacherDelegatorImpl implements TeacherDelegator {

	@Autowired
	TeacherDAOImpl teacherDAO;
	@Autowired
	TeacherTransformer teacherTransformer;

	public TeacherResponse processTeacher(TeacherRequest teacher) {
		if (teacher.getRequestType() == "insert") {
			Teacher teacherObj = new Teacher();
			List<Teacher> teacherList = new ArrayList<Teacher>();
			teacherObj = teacherDAO.insertTeacher(teacher.getTeacher());
			teacherList.add(teacherObj);
			return teacherTransformer.responseTransformer(teacherList);
		}
		if (teacher.getRequestType() == "delete") {
			Teacher teacherObj = new Teacher();
			List<Teacher> teacherList = new ArrayList<Teacher>();
			teacherObj = teacherDAO.deleteTeacherById(teacher.getTeacher().getTeacherId());
			teacherList.add(teacherObj);
			return teacherTransformer.responseTransformer(teacherList);
		}
		if (teacher.getRequestType() == "update") {
			Teacher teacherObj = new Teacher();
			List<Teacher> teacherList = new ArrayList<Teacher>();
			teacherObj = teacherDAO.updateTeacher(teacher.getTeacher());
			teacherList.add(teacherObj);
			return teacherTransformer.responseTransformer(teacherList);

		}
		if (teacher.getRequestType() == "getAll") {
			List<Teacher> teacherList = new ArrayList<Teacher>();
			teacherList = teacherDAO.getAllTeacher();
			return teacherTransformer.responseTransformer(teacherList);
		}
		if (teacher.getRequestType() == "getById") {
			Teacher teacherObj = new Teacher();
			List<Teacher> teacherList = new ArrayList<Teacher>();
			teacherObj = teacherDAO.getTeacherById(teacher.getTeacher().getTeacherId());
			teacherList.add(teacherObj);
			return teacherTransformer.responseTransformer(teacherList);

		}
		return null;
	}
}
