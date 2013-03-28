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
@Table(name = "category_table")
public class Category implements Serializable {

	private static final Long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Set<Assignment> assignment;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "category_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "category")
	public Set<Assignment> getAssignment() {
		return assignment;
	}

	public void setAssignment(Set<Assignment> assignment) {
		this.assignment = assignment;
	}

}
