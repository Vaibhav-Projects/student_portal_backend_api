package com.vaibhav.school.portal.dao;

import java.util.List;

import com.vaibhav.school.portal.entity.Student;
import com.vaibhav.school.portal.entity.Subject;
import com.vaibhav.school.portal.entity.Teacher;

public interface TeacherDAO {

	public Teacher insertTeacher(Teacher teacher);

	public Teacher deleteTeacherById(int teacherId);

	public Teacher updateTeacher(Teacher teacher);

	public List<Teacher> getAllTeacher();

	public List<Subject> getTeacherAllSubjectsById(int teacherId);

	public List<Student> getTeacherAllStudentsById(int teacherId);

	public Teacher getTeacherById(int teacherId);

	public Teacher setClassToTeacherById(String clas, int teacherId);

	public Teacher setSubjectToTeacherById(int teacherId, int subjectId);

}
