package com.vaibhav.school.portal.dao;

import java.util.List;

import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.entity.Subject;

public interface StudentDAO {

	public Student updateStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(int studentId);

	public List<Student> getStudentsByClassAndSection(String clas, String section);

	public List<Student> getStudentsByClass(String clas);

	public Student deleteStudentById(int studentId);

	public Student insertStudent(Student student);

	public List<Subject> getStudentAllSubjectsById(int studentId);

	public Student setSubjectToStudentById(int studentId, int subjectId);

}
