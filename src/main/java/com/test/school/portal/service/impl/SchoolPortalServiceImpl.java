package com.test.school.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.school.portal.business.impl.StudentBoImpl;
import com.test.school.portal.business.impl.SubjectBoImpl;
import com.test.school.portal.business.impl.TeacherBoImpl;
import com.test.school.portal.dao.impl.StudentDAOImpl;
import com.test.school.portal.dao.impl.SubjectDAOImpl;
import com.test.school.portal.dao.impl.TeacherDAOImpl;
import com.test.school.portal.entity.Student;
import com.test.school.portal.entity.Subject;
import com.test.school.portal.entity.Teacher;
import com.test.school.portal.service.SchoolPortalService;
import com.test.school.portal.service.request.StudentRequest;
import com.test.school.portal.service.request.SubjectRequest;
import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.StudentResponse;
import com.test.school.portal.service.response.SubjectResponse;
import com.test.school.portal.service.response.TeacherResponse;
import com.test.school.portal.transformer.StudentTransformer;
import com.test.school.portal.transformer.SubjectTransformer;
import com.test.school.portal.transformer.TeacherTransformer;
import com.test.school.portal.utils.StudentUtils;
import com.test.school.portal.utils.SubjectUtils;
import com.test.school.portal.utils.TeacherUtils;

@RestController
public class SchoolPortalServiceImpl implements SchoolPortalService {

	@Autowired
	StudentUtils studentUtils;
	@Autowired
	SubjectUtils subjectUtils;
	@Autowired
	TeacherUtils teacherUtils;
	@Autowired
	StudentBoImpl studentBo;
	@Autowired
	SubjectBoImpl subjectBo;
	@Autowired
	TeacherBoImpl teacherBo;

	Logger logger = LoggerFactory.getLogger(SchoolPortalServiceImpl.class);

	@RequestMapping(method = RequestMethod.GET, value = "/Students", produces = { "application/JSON",
			"application/XML" })
	@Override
	public StudentResponse getAllStudents() {
		logger.info("Getting All Students Details");
		StudentResponse studentResponse = null;
		try {
			Student student = new Student();
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "getAll");
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/Students/Student", consumes = { "application/JSON",
			"application/XML" }, produces = { "application/JSON", "application/XML" })
	@Override
	public StudentResponse updateStudent(@RequestBody Student student) {
		logger.info("Updating Student Details: ", student);
		StudentResponse studentResponse = null;
		try {
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "update");
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Students/Student/{studentId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public StudentResponse getStudentById(@PathVariable("studentId") int studentId) {
		logger.info("Getting Student Details Of Id: {} ", studentId);
		StudentResponse studentResponse = null;
		try {
			Student student = new Student();
			student.setStudentId(studentId);
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "getById");
			studentResponse = new StudentResponse();
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Students/Student/{clas}/{section}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public StudentResponse getStudentsByClassAndSection(@PathVariable("clas") String clas,
			@PathVariable("section") String section) {
		logger.info("Getting Students Details Of Class: {} And Section: {} ", clas, section);
		StudentResponse studentResponse = null;
		try {
			Student student = new Student();
			student.setStudentSection(section);
			student.setStudentClass(clas);
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "getByClassAndSection");
			studentResponse = new StudentResponse();
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Students/Student", produces = { "application/JSON",
			"application/XML" })
	@Override
	public StudentResponse getStudentsByClass(@QueryParam("clas") String clas) {
		logger.info("Getting Students Details Of Class: {} ", clas);
		StudentResponse studentResponse = null;
		try {
			Student student = new Student();
			student.setStudentClass(clas);
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "getByClass");
			studentResponse = new StudentResponse();
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Students/Student/{studentId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public StudentResponse deleteStudentById(@PathVariable("studentId") int studentId) {
		logger.info("Deleting Students Details Of Id: {} ", studentId);
		StudentResponse studentResponse = null;
		try {
			Student student = new Student();
			student.setStudentId(studentId);
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "delete");
			studentResponse = new StudentResponse();
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Students/Student", produces = { "application/JSON",
			"application/XML" }, consumes = { "application/JSON", "application/XML" })
	@Override
	public StudentResponse insertStudent(@RequestBody Student student) {
		logger.info("Inserting Students Details: {} ", student);
		StudentResponse studentResponse = null;
		try {
			StudentRequest studentRequest = studentUtils.buildStudentRequest(student, "insert");
			studentResponse = new StudentResponse();
			studentResponse = studentBo.lookUpStudent(studentRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Subjects/Subject", produces = { "application/JSON",
			"application/XML" }, consumes = { "application/JSON", "application/XML" })
	@Override
	public SubjectResponse insertSubject(@RequestBody Subject subject) {
		logger.info("Inserting Subject Details : {} ", subject);
		SubjectResponse subjectResponse = null;
		try {
			SubjectRequest subjectRequest = subjectUtils.buildSubjectRequest(subject, "insert");
			subjectResponse = new SubjectResponse();
			subjectResponse = subjectBo.lookUpSubject(subjectRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return subjectResponse;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Subjects/Subject/{subjectId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public SubjectResponse deleteSubjectById(@PathVariable("subjectId") int subjectId) {
		logger.info("Deleting Subject Details Of Id : {} ", subjectId);
		SubjectResponse subjectResponse = null;
		try {
			Subject subject = new Subject();
			subject.setSubjectId(subjectId);
			SubjectRequest subjectRequest = subjectUtils.buildSubjectRequest(subject, "delete");
			subjectResponse = new SubjectResponse();
			subjectResponse = subjectBo.lookUpSubject(subjectRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return subjectResponse;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/Subjects/Subject", produces = { "application/JSON",
			"application/XML" }, consumes = { "application/JSON", "application/XML" })
	@Override
	public SubjectResponse updateSubject(@RequestBody Subject subject) {
		logger.info("Updating Subject Details : {} ", subject);
		SubjectResponse subjectResponse = null;
		try {
			SubjectRequest subjectRequest = subjectUtils.buildSubjectRequest(subject, "update");
			subjectResponse = new SubjectResponse();
			subjectResponse = subjectBo.lookUpSubject(subjectRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return subjectResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Subjects", produces = { "application/JSON",
			"application/XML" })
	@Override
	public SubjectResponse getAllSubject() {
		logger.info("Getting All Subject Details");
		SubjectResponse subjectResponse = null;
		try {
			Subject subject = new Subject();
			SubjectRequest subjectRequest = subjectUtils.buildSubjectRequest(subject, "getAll");
			subjectResponse = new SubjectResponse();
			subjectResponse = subjectBo.lookUpSubject(subjectRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return subjectResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Subjects/Subject/{subjectId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public SubjectResponse getSubjectById(@PathVariable("subjectId") int subjectId) {
		logger.info("Getting Subject Details Of Id : {} ", subjectId);
		SubjectResponse subjectResponse = null;
		try {
			Subject subject = new Subject();
			subject.setSubjectId(subjectId);
			SubjectRequest subjectRequest = subjectUtils.buildSubjectRequest(subject, "getById");
			subjectResponse = new SubjectResponse();
			subjectResponse = subjectBo.lookUpSubject(subjectRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return subjectResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Teachers/Teacher", produces = { "application/JSON",
			"application/XML" }, consumes = { "application/JSON", "application/XML" })
	@Override
	public TeacherResponse insertTeacher(@RequestBody Teacher teacher) {
		logger.info("Inseting Teacher Details : {} ", teacher);
		TeacherResponse teacherResponse = null;
		try {
			TeacherRequest teacherRequest = teacherUtils.buildTeacherRequest(teacher, "insert");
			teacherResponse = new TeacherResponse();
			teacherResponse = teacherBo.lookUpTeacher(teacherRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherResponse;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Teachers/Teacher/{teacherId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public TeacherResponse deleteTeacherById(@PathVariable("teacherId") int teacherId) {
		logger.info("Deleting Teacher Details Of Id : {} ", teacherId);
		TeacherResponse teacherResponse = null;
		try {
			Teacher teacher = new Teacher();
			teacher.setTeacherId(teacherId);
			TeacherRequest teacherRequest = teacherUtils.buildTeacherRequest(teacher, "delete");
			teacherResponse = new TeacherResponse();
			teacherResponse = teacherBo.lookUpTeacher(teacherRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherResponse;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/Teachers/Teacher", produces = { "application/JSON",
			"application/XML" }, consumes = { "application/JSON", "application/XML" })
	@Override
	public TeacherResponse updateTeacher(@RequestBody Teacher teacher) {
		logger.info("Updating Teacher Details : {} ", teacher);
		TeacherResponse teacherResponse = null;
		try {
			TeacherRequest teacherRequest = teacherUtils.buildTeacherRequest(teacher, "update");
			teacherResponse = new TeacherResponse();
			teacherResponse = teacherBo.lookUpTeacher(teacherRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Teachers", produces = { "application/JSON",
			"application/XML" })
	@Override
	public TeacherResponse getAllTeacher() {
		logger.info("Getting All Teacher Details");
		TeacherResponse teacherResponse = null;
		try {
			Teacher teacher = new Teacher();
			TeacherRequest teacherRequest = teacherUtils.buildTeacherRequest(teacher, "getAll");
			teacherResponse = new TeacherResponse();
			teacherResponse = teacherBo.lookUpTeacher(teacherRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Teachers/Teacher/{teacherId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public TeacherResponse getTeacherById(@PathVariable("teacherId") int teacherId) {
		logger.info("Getting Teacher Details Of Id: {} ", teacherId);
		TeacherResponse teacherResponse = null;
		try {
			Teacher teacher = new Teacher();
			teacher.setTeacherId(teacherId);
			TeacherRequest teacherRequest = teacherUtils.buildTeacherRequest(teacher, "getById");
			teacherResponse = new TeacherResponse();
			teacherResponse = teacherBo.lookUpTeacher(teacherRequest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherResponse;
	}

	@Autowired
	StudentDAOImpl studentDao;
	@Autowired
	SubjectDAOImpl subjectDao;
	@Autowired
	TeacherDAOImpl teacherDao;
	@Autowired
	StudentTransformer studentTransformer;
	@Autowired
	SubjectTransformer subjectTransformer;
	@Autowired
	TeacherTransformer teacherTransformer;

	@RequestMapping(method = RequestMethod.PUT, value = "/Students/Subject", produces = { "application/JSON",
			"application/XML" })
	@Override
	public StudentResponse setSubjectToStudentById(@QueryParam("subjectId") int subjectId,
			@QueryParam("studentId") int studentId) {
		logger.info("Inserting Subject Details With Id: {} To Study By Student With Id: {}  ", subjectId, studentId);
		List<Student> studentList = new ArrayList<Student>();
		try {
			Student student = new Student();
			student = studentDao.setSubjectToStudentById(studentId, subjectId);
			studentList.add(student);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentTransformer.responseTransformer(studentList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Teachers/Subjects/{teacherId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public SubjectResponse getTeacherAllSubjectsById(@PathVariable("teacherId") int teacherId) {
		logger.info("Getting Details Of All Subjects Teached By Teacher With Id: {} ", teacherId);
		List<Subject> subjectList = new ArrayList<Subject>();
		try {
			subjectList = teacherDao.getTeacherAllSubjectsById(teacherId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return subjectTransformer.responseTransformer(subjectList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Teachers/Students/{teacherId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public StudentResponse getTeacherAllStudentsById(@PathVariable("teacherId") int teacherId) {
		logger.info("Getting Details Of All Students Teached By Teacher With Id: {} ", teacherId);
		List<Student> studentList = new ArrayList<Student>();
		try {
			studentList = teacherDao.getTeacherAllStudentsById(teacherId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return studentTransformer.responseTransformer(studentList);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/Students/Teacher", produces = { "application/JSON",
			"application/XML" })
	@Override
	public TeacherResponse setClassToTeacherById(@QueryParam("clas") String clas,
			@QueryParam("teacherId") int teacherId) {
		logger.info("Inserting Class Details: {} To Teach By Teacher With Id: {} ", clas, teacherId);
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			Teacher teacher = new Teacher();
			teacher = teacherDao.setClassToTeacherById(clas, teacherId);
			teacherList.add(teacher);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherTransformer.responseTransformer(teacherList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Students/Subjects/{studentId}", produces = {
			"application/JSON", "application/XML" })
	@Override
	public SubjectResponse getStudentAllSubjectsById(@PathVariable("studentId") int studentId) {
		logger.info("Getting Details Of All Subjects Studied By Student With Id: {} ", studentId);
		List<Subject> subjectList = new ArrayList<>();
		try {
			subjectList = studentDao.getStudentAllSubjectsById(studentId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return subjectTransformer.responseTransformer(subjectList);

	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = "/Teachers/Subjects", produces = { "application/JSON",
			"application/XML" })
	public TeacherResponse setSubjectToTeacherById(@QueryParam("teacherId") int teacherId,
			@QueryParam("subjectId") int subjectId) {

		logger.info("Inserting Subject Details With Id: {} To Teach By Teacher With Id: {} ", subjectId, teacherId);
		List<Teacher> teacherList = new ArrayList<>();
		try {
			Teacher teacher = new Teacher();
			teacher = teacherDao.setSubjectToTeacherById(teacherId, subjectId);
			teacherList.add(teacher);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return teacherTransformer.responseTransformer(teacherList);
	}

}