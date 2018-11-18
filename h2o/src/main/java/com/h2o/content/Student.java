package com.h2o.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the student. ")

/**
 * Class for creating a Student object.
 * 
 * @author shilpakancharla
 */

public class Student {
	@Id
	@GeneratedValue

	/** ID number (in Wrapper class) */
	private Long id;
	
	@ApiModelProperty(notes="Name should have at least 2 characters")
	@Size(min=2, message="Name should have at least 2 characters")

	/** Name */
	private String name;
	
	/** Passport number */
	private String passportNumber;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
		
}
