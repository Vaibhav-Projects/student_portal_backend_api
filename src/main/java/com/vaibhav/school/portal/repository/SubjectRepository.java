package com.vaibhav.school.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.school.portal.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	public List<Subject> findAll();

	public Subject findBySubjectId(int subjectId);

	public int deleteBySubjectId(int subjectId);
}
