package com.h2o.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the Content. ")

public class Content {

	@Id

	@GeneratedValue

	/** ID (in Wrapper class) */
	private Long id;
	
	@ApiModelProperty(notes="Name should have at least 2 characters")
	@Size(min=2, message="Name should have at least 2 characters")

	/** Title */
	private String title;
	
	/** Topic */
	private String topics;
	
	/**
	 * Constructor for Content object 
	 *
	 * @param id
	 * @param title
	 * @param topics
	 */

	public Content(Long id, String title, String topics) {		
		super();
		this.id = id;
		this.title = title;
		this.topics = topics;
	}

	/**
	 * Getter method for ID.
	 *
	 * @return ID number of information/article
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Setter method for ID.
	 *
	 * @param id ID number of information/article
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter method for topic.
	 *
	 * @return topics of information/article
	 */
	
	public String getTopics() {
		return topics;
	}

	/**
	 * Setter method for topics.
	 *
	 * @param topics of information/article
	 */

	public void setTopics(String topics) {
		this.topics = topics;
	}

	/**
	 * Getter method for title.
	 *
	 * @return title of information/article
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * Setter method for topics.
	 *
	 * @param topics of information/article
	 */

	public void setTitle(String title) {
		this.title = title;
	}		
}
