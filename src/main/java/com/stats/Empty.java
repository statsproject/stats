package com.stats;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.SetSupport;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.stats.domain.Grade;
import com.stats.domain.Student;

import com.stats.service.GradeService;
import com.stats.service.StudentService;

public class Empty {

	private static void listAll(List<Student> list) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Student student : list) {
			System.out.print("Get all >> "+student.getStudentId() + " "
					+ student.getFirstName() + " " + student.getLastName()
					+ " " + student.getEmail() + " "
					+ sdf.format(student.getDob()));
			System.out.println();
		}
	}
	private static void listAllWithDetails(List<Student> list) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Student student : list) {
			System.out.print("Get all with details: >> "+student.getStudentId() + " "
					+ student.getFirstName() + " " + student.getLastName()
					+ " " + student.getEmail() + " "
					+ sdf.format(student.getDob()));
			if(student.getGrades()!=null){
				for(Grade grade:student.getGrades()){
					System.out.print(" Grades: >> "+grade.getGrade());
				}
			}
			if(student.getClasses()!=null){
				for(com.stats.domain.Class clazz:student.getClasses()){
					System.out.print(" Classes: >> "+clazz.getName());
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FileSystemXmlApplicationContext cxt = new FileSystemXmlApplicationContext(
				"src/main/webapp/META-INF/applicationContext.xml");
		cxt.refresh();
		StudentService studentService = (StudentService) cxt.getBean(
				"jpaStudentService", StudentService.class);
		GradeService gradeService = (GradeService) cxt.getBean(
				"jpaGradeService", GradeService.class);
		Student student = new Student();
		student.setStudentId("004");
		student.setFirstName("Sam");
		student.setLastName("Ham");
		student.setDob(new Date(123));
		student.setEmail("st4@mail.edu");
		System.out.println("Add student >> "+studentService.addStudent(student));
		System.out.println("Find by student id >> "+studentService.getByStudentId("004").getFirstName());
		student = studentService.getWithDetailsByStudentId("003");
		System.out.println("Find with details by student id >>"+student.getFirstName()+" "+(student.getGrades()!=null));
		System.out.println("Find by id >>"+studentService.getById(4L).getFirstName());
		student = studentService.getWithDetailsById(4L);
		System.out.println("Find with details by id >>"+student.getFirstName()+" "+(student.getGrades()!=null));
		
		listAll(studentService.getAll());
		listAllWithDetails(studentService.getAllWithDetails());
		
		
		System.out.println("Find all by last name >>"+studentService.getAllByLastName("Ham").get(0).getFirstName());
		System.out.println("Find all with details by last name >>"+studentService.getAllWithDetailsByLastName("Ham").get(0).getFirstName());
		System.out.println("Find all by dob >> "+studentService.getAllByDob(new Date(123)).get(0).getFirstName());
		System.out.println("Find all with details by dob >> "+studentService.getAllWithDetailsByDob(new Date(123)).get(0).getFirstName());
		listAll(studentService.getAllByLastName("Ham"));
		listAllWithDetails(studentService.getAllWithDetailsByLastName("Ham"));
		listAll(studentService.getAllByDob(new Date(123)));
		listAllWithDetails(studentService.getAllWithDetailsByDob(new Date(123)));
		
//		List<Grade> grades= gradeService.getGr("testStudentLastName1","testStudentFirstName1");
//		for(Grade grade : grades){
//			System.out.print(grade.getAssignment().getCategory().getName()+" ");
//			System.out.print(grade.getAssignment().getName()+" ");
//			System.out.print(grade.getGrade());
//			System.out.println();
//		}
	}
}
