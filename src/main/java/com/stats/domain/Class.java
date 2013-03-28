package com.stats.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "class_table")
@NamedQueries({
	@NamedQuery(name = "Class.findAllGradesByClassName", query = "select cl from Class cl "
			+ "left join fetch cl.students st where "
			+ "cl.name=:className") 
})
public class Class implements Serializable {

	private static final Long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Teacher teacher;
	private Set<Student> students;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "class_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToMany
	@JoinTable(name = "student_class_table", 
	joinColumns = @JoinColumn(name = "class_id"), 
	inverseJoinColumns = @JoinColumn(name = "student_id"))
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
