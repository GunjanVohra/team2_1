package com.cg.capbook.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Status {
	@Id
	@GeneratedValue
	private int postId;
	private String postBody;
	@ManyToOne
	private UserProfile user;
	
	@OneToMany(mappedBy="post")
	@MapKey
	private List<Likes>likes;
	
	@OneToMany(mappedBy="post")
	@MapKey
	private List<Comments>comments;
	
}
