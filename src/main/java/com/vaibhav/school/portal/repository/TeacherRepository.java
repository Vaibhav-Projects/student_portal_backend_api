package com.vaibhav.school.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.school.portal.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	public List<Teacher> findAll();

	public Teacher findByTeacherId(int teacherId);

	public int deleteByTeacherId(int teacherId);
}
