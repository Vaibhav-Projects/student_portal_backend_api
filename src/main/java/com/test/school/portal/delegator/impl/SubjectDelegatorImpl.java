package com.test.school.portal.delegator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.school.portal.dao.impl.SubjectDAOImpl;
import com.test.school.portal.delegator.SubjectDelegator;
import com.test.school.portal.entity.Subject;
import com.test.school.portal.service.request.SubjectRequest;
import com.test.school.portal.service.response.SubjectResponse;
import com.test.school.portal.transformer.SubjectTransformer;

@Component
public class SubjectDelegatorImpl implements SubjectDelegator {

	@Autowired
	SubjectDAOImpl subjectDAO;
	@Autowired
	SubjectTransformer subjectTransformer;

	public SubjectResponse processSubject(SubjectRequest subject) {
		if (subject.getRequestType() == "insert") {
			Subject subjectObj = new Subject();
			List<Subject> subjectList = new ArrayList<>();
			subjectObj = subjectDAO.insertSubject(subject.getSubject());
			subjectList.add(subjectObj);
			return subjectTransformer.responseTransformer(subjectList);
		}
		if (subject.getRequestType() == "delete") {
			List<Subject> subjectList = new ArrayList<Subject>();
			Subject subjectObj = new Subject();
			subjectObj = subjectDAO.deleteSubjectById(subject.getSubject().getSubjectId());
			subjectList.add(subjectObj);
			return subjectTransformer.responseTransformer(subjectList);
		}
		if (subject.getRequestType() == "update") {
			Subject subjectObj = new Subject();
			List<Subject> subjectList = new ArrayList<Subject>();
			subjectObj = subjectDAO.updateSubject(subject.getSubject());
			subjectList.add(subjectObj);
			return subjectTransformer.responseTransformer(subjectList);
		}
		if (subject.getRequestType() == "getAll") {
			List<Subject> subjectList = new ArrayList<Subject>();
			subjectList = subjectDAO.getAllSubject();
			return subjectTransformer.responseTransformer(subjectList);
		}
		if (subject.getRequestType() == "getById") {
			Subject subjectObj = new Subject();
			List<Subject> subjectList = new ArrayList<Subject>();
			subjectObj = subjectDAO.getSubjectById(subject.getSubject().getSubjectId());
			subjectList.add(subjectObj);
			return subjectTransformer.responseTransformer(subjectList);
		}
		return null;
	}
}
