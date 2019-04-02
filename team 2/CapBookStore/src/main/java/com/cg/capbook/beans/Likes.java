package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Likes {
	@Id
	@GeneratedValue
	private int likeId;
	private String likedBy;
	private int count;
	@ManyToOne
	private Status post;
	
}
