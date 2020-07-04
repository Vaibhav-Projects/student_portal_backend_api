package com.test.school.portal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.school.portal.dao.StudentDAO;
import com.test.school.portal.entity.Student;
import com.test.school.portal.entity.Subject;
import com.test.school.portal.repository.StudentRepository;
import com.test.school.portal.repository.SubjectRepository;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Student updateStudent(Student student) {
		Student updatedStudent = studentRepository.findByStudentId(student.getStudentId());
		updatedStudent.setStudentAddress(student.getStudentAddress());
		updatedStudent.setStudentFatherName(student.getStudentFatherName());
		updatedStudent.setStudentMotherName(student.getStudentMotherName());
		updatedStudent.setStudentClass(student.getStudentClass());
		updatedStudent.setStudentPhone(student.getStudentPhone());
		updatedStudent.setStudentSection(student.getStudentSection());
		updatedStudent.setStudentName(student.getStudentName());
		updatedStudent.setSubjectList(student.getSubjectList());
		updatedStudent.setTeacherList(student.getTeacherList());
		return updatedStudent;
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentRepository.findByStudentId(studentId);
	}

	@Override
	public List<Student> getStudentsByClassAndSection(String clas, String section) {
		return studentRepository.findByStudentClassAndStudentSection(clas, section);
	}

	@Override
	public List<Student> getStudentsByClass(String clas) {
		return studentRepository.findByStudentClass(clas);
	}

	@Override
	public Student deleteStudentById(int studentId) {
		Student student = studentRepository.findByStudentId(studentId);
		studentRepository.deleteByStudentId(studentId);
		return student;
	}

	@Override
	public Student setSubjectToStudentById(int studentId, int subjectId) {
		Student student = studentRepository.findByStudentId(studentId);
		Subject subject = subjectRepository.findBySubjectId(subjectId);
		List<Subject> subjectList = student.getSubjectList();
		subjectList.add(subject);
		student.setSubjectList(subjectList);
		studentRepository.save(student);
		return student;
	}

	@Override
	public Student insertStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public List<Subject> getStudentAllSubjectsById(int studentId) {
		Student student = studentRepository.findByStudentId(studentId);
		List<Subject> subjectList = student.getSubjectList();
		return subjectList;
	}
}