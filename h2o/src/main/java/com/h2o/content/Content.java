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
	private Long id;
	
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	@Size(min=2, message="Name should have atleast 2 characters")
	private String title;
	
	private String topics;
	
	public Content() {
		super();
	}

	//public Content(Long id, String title, String date) {
		public Content(Long id, String title, String topics) {		
		super();
		this.id = id;
		this.title = title;
		this.topics = topics;
	}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTopics() {
			return topics;
		}

		public void setTopics(String topics) {
			this.topics = topics;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		
}
