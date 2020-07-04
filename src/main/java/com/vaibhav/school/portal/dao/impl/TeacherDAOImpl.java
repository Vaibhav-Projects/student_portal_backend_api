package com.vaibhav.school.portal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.dao.TeacherDAO;
import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.entity.Subject;
import com.vaibhav.school.portal.entity.Teacher;
import com.vaibhav.school.portal.repository.StudentRepository;
import com.vaibhav.school.portal.repository.SubjectRepository;
import com.vaibhav.school.portal.repository.TeacherRepository;

@Component
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Teacher insertTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
		return teacher;
	}

	@Override
	public Teacher deleteTeacherById(int teacherId) {
		Teacher teacher = teacherRepository.findByTeacherId(teacherId);
		teacherRepository.deleteByTeacherId(teacherId);
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher updatedTeacher = teacherRepository.findByTeacherId(teacher.getTeacherId());
		updatedTeacher.setTeacherName(teacher.getTeacherName());
		updatedTeacher.setTeacherPhone(teacher.getTeacherPhone());
		updatedTeacher.setTeacherAddress(teacher.getTeacherAddress());
		updatedTeacher.setStudentList(teacher.getStudentList());
		updatedTeacher.setSubjectsList(teacher.getSubjectsList());
		return updatedTeacher;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	@Override
	public List<Subject> getTeacherAllSubjectsById(int teacherId) {
		Teacher teacher = teacherRepository.findByTeacherId(teacherId);
		List<Subject> subjectList = teacher.getSubjectsList();
		return subjectList;
	}

	@Override
	public List<Student> getTeacherAllStudentsById(int teacherId) {
		Teacher teacher = teacherRepository.findByTeacherId(teacherId);
		List<Student> studentList = teacher.getStudentList();
		return studentList;
	}

	@Override
	public Teacher setClassToTeacherById(String clas, int teacherId) {
		List<Student> studentList = studentRepository.findByStudentClass(clas);
		Teacher teacher = teacherRepository.findByTeacherId(teacherId);
		teacher.setStudentList(studentList);
		teacherRepository.save(teacher);
		return teacher;
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		return teacherRepository.findByTeacherId(teacherId);
	}

	@Override
	public Teacher setSubjectToTeacherById(int teacherId, int subjectId) {
		Teacher teacher = teacherRepository.findByTeacherId(teacherId);
		Subject subject = subjectRepository.findBySubjectId(subjectId);
		List<Subject> subjectList = teacher.getSubjectsList();
		subjectList.add(subject);
		teacher.setSubjectsList(subjectList);
		teacherRepository.save(teacher);
		return teacher;
	}
}
