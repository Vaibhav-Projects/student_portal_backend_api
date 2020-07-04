package com.test.school.portal.service;

import com.test.school.portal.entity.Student;
import com.test.school.portal.entity.Subject;
import com.test.school.portal.entity.Teacher;
import com.test.school.portal.service.response.StudentResponse;
import com.test.school.portal.service.response.SubjectResponse;
import com.test.school.portal.service.response.TeacherResponse;

public interface SchoolPortalService {

	public StudentResponse updateStudent(Student student);

	public StudentResponse getAllStudents();

	public StudentResponse getStudentById(int studentId);

	public StudentResponse getStudentsByClassAndSection(String clas, String section);

	public StudentResponse getStudentsByClass(String clas);

	public StudentResponse deleteStudentById(int studentId);

	public StudentResponse insertStudent(Student student);

	public SubjectResponse insertSubject(Subject subject);

	public SubjectResponse deleteSubjectById(int subjectId);

	public SubjectResponse updateSubject(Subject subject);

	public SubjectResponse getAllSubject();

	public SubjectResponse getSubjectById(int subjectId);

	public TeacherResponse insertTeacher(Teacher teacher);

	public TeacherResponse deleteTeacherById(int teacherId);

	public TeacherResponse updateTeacher(Teacher teacher);

	public TeacherResponse getAllTeacher();

	public SubjectResponse getTeacherAllSubjectsById(int teacherId);

	public StudentResponse getTeacherAllStudentsById(int teacherId);

	public TeacherResponse getTeacherById(int teacherId);

	public StudentResponse setSubjectToStudentById(int studentId, int subjectId);

	public TeacherResponse setClassToTeacherById(String clas, int teacherId);

	public SubjectResponse getStudentAllSubjectsById(int studentId);

	public TeacherResponse setSubjectToTeacherById(int teacherId, int subjectId);
}
