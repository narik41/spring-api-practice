package com.kiran.demoapi.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private Integer id ; 
	
	@NotBlank
	private String name ; 
	
	public Person(@JsonProperty("id")Integer id, 
			@JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
}
