package com.stats.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student_table")
@NamedQueries({
		// good
		@NamedQuery(name = "Student.findAll", query = "select s from Student s"),
		// good
		@NamedQuery(name = "Student.findById", query = "select distinct s from Student s "
				+ "left join s.grades g left join fetch s.classes c where s.id=:id"),
		// good
		@NamedQuery(name = "Student.findWithDetailsByStudentId", query = "select distinct s from Student s "
				+ "left join s.grades g left join fetch s.classes c where s.studentId=:student_id"),
		// good
		@NamedQuery(name = "Student.findAllWithDetails", query = "select distinct s from Student s "
				+ "left join s.grades g left join fetch s.classes c"),
		// good
		@NamedQuery(name = "Student.findByStudentId", query = "select distinct s from Student s "
				+ "where s.studentId=:student_id"),
		// good
		@NamedQuery(name = "Student.findWithDetailsById", query = "select distinct s from Student s "
				+ "left join s.grades g left join fetch s.classes c where s.id=:id"),
		// good
		@NamedQuery(name = "Student.findAllByLastName", query = "select distinct s from Student s "
				+ "where s.lastName=:last_name"),
		// good
		@NamedQuery(name = "Student.findAllWithDetailsByLastName", query = "select distinct s from Student s "
				+ "left join s.grades g left join fetch s.classes c where s.lastName=:last_name"),
		// good
		@NamedQuery(name = "Student.findAllByDob", query = "select distinct s from Student s "
				+ "where s.dob between :dob and :dob"),
		// good
		@NamedQuery(name = "Student.findAllWithDetailsByDob", query = "select distinct s from Student s "
				+ "left join s.grades g left join fetch s.classes c where s.dob between :dob and :dob") })
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String studentId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	private Long cleverId;
	private Set<Grade> grades;
	private Set<Class> classes;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "student_first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "student_last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "student_school_id")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "student_clever_id")
	public Long getCleverId() {
		return cleverId;
	}

	public void setCleverId(Long cleverId) {
		this.cleverId = cleverId;
	}

	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_class_table", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "class_id"))
	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Student))
			return false;
		Student obj = (Student) object;
		if (this.firstName.equals(obj.getFirstName())
				&& this.lastName.equals(obj.getLastName()))
			return true;
		else
			return false;
	}

}
