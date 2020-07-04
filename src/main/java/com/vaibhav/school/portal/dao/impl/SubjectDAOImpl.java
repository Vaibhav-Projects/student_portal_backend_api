package com.vaibhav.school.portal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaibhav.school.portal.dao.SubjectDAO;
import com.vaibhav.school.portal.entity.Subject;
import com.vaibhav.school.portal.repository.SubjectRepository;

@Component
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Subject insertSubject(Subject subject) {
		subjectRepository.save(subject);
		return subject;
	}

	@Override
	public Subject deleteSubjectById(int subjectId) {
		Subject subject = subjectRepository.findBySubjectId(subjectId);
		subjectRepository.deleteBySubjectId(subjectId);
		return subject;
	}

	@Override
	public Subject updateSubject(Subject subject) {
		Subject updatedSubject = subjectRepository.findBySubjectId(subject.getSubjectId());
		updatedSubject.setSubjectId(subject.getSubjectId());
		updatedSubject.setSubjectName(subject.getSubjectName());
		updatedSubject.setStudentList(subject.getStudentList());
		updatedSubject.setTeacherList(subject.getTeacherList());
		return updatedSubject;
	}

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		return subjectRepository.findBySubjectId(subjectId);
	}

}
