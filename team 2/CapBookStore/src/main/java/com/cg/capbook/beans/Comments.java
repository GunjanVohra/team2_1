package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comments {
	@Id
	@GeneratedValue
	private int commentId;
	private String commentBy;
	private String commentMessage;
	@ManyToOne
	private Status post;
		
}
