package com.stats.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_table")
@NamedQueries({
		@NamedQuery(name = "Teacher.findAll", query = "select t from Teacher t"),
		@NamedQuery(name = "Teacher.findById", query = "select distinct t from Teacher t "
				+ "left join t.classes c where t.id=:id"),
		@NamedQuery(name = "Teacher.findByName", query = "select distinct t from Teacher t "
				+ "left join t.classes c where t.firstName=:firstName and t.lastName=:lastName"),
		@NamedQuery(name = "Teacher.login", query = "select distinct t from Teacher t "
				+ "left join t.classes c where t.login=:login and t.password=:password") })
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String teacherId;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String email;
	private Long cleverTeacherId;
	private Set<Class> classes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "teacher_first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "teacher_last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "teacher_school_id")
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "passwd")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "teacher_clever_id")
	public Long getCleverTeacherId() {
		return cleverTeacherId;
	}

	public void setCleverTeacherId(Long cleverTeacherId) {
		this.cleverTeacherId = cleverTeacherId;
	}

	@OneToMany(mappedBy = "teacher")
	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

}
