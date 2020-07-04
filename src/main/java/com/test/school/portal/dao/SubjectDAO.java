package com.test.school.portal.dao;

import java.util.List;

import com.test.school.portal.entity.Subject;

public interface SubjectDAO {

	public Subject insertSubject(Subject subject);

	public Subject deleteSubjectById(int subjectId);

	public Subject updateSubject(Subject subject);

	public List<Subject> getAllSubject();

	public Subject getSubjectById(int subjectId);

}
