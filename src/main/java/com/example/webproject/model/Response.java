package com.example.webproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Response
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String rightans;
	
	public Response()
	{
		
	}
	
	public Response( String question,String rightans) {
		super();
		this.id=id;
		this.rightans = rightans;
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRightans(String rightans) {
		this.rightans = rightans;
	}
	
	
	public String getRightans()
	{
		return rightans;
	}
	
	
	
}
