package com.vaibhav.school.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.school.portal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findAll();

	public List<Student> findByStudentClass(String clas);

	public List<Student> findByStudentClassAndStudentSection(String clas, String section);

	public int deleteByStudentId(int studentId);

	public Student findByStudentId(int studentId);

}
