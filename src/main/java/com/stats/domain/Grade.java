package com.stats.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "grade_table")
@NamedQueries({
		@NamedQuery(name = "Grade.findAllGradesByName", query = "select gr from Grade gr "
				+ "left join fetch gr.assignment assn where "
				+ "gr.student.lastName=:last_name and gr.student.firstName=:first_name"),
		@NamedQuery(name = "Grade.findAllAssignmentsByCategoryName", query = "select gr from Grade gr "
				+ "left join fetch gr.assignment assn where "
				+ "gr.assignment.category.name=:categoryName"),
		@NamedQuery(name = "Grade.findAllGradesByClassName", query = "select gr from Grade gr "
				+ "left join fetch gr.assignment assn where "
				+ "gr.assignment.clazz.name=:className") })
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Double grade;
	private Student student;
	private Assignment assignment;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grade_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "grade")
	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "assignment_id")
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

}
