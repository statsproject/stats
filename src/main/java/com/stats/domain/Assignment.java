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
@Table(name = "assignment_table")
@NamedQueries({
		@NamedQuery(name = "Assignment.findByCategoryName", query = "select a from Assignment a left join fetch a.category ca where ca.name:=categoryName"),
		@NamedQuery(name = "Assignment.findByName", query = "select a from Assignment a where a.name:=name"),
		
		@NamedQuery(name = "Assignment.find", query = "select a from Assignment a"),
		@NamedQuery(name = "Assignment.findById", query = "select a from Assignment a "
				+ "left join fetch a.clazz cl left join fetch a.category ca where a.id=:id") })
public class Assignment implements Serializable {

	private static final Long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private Class clazz;
	private Category category;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assignment_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "assignment_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "assignment_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "class_id")
	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
