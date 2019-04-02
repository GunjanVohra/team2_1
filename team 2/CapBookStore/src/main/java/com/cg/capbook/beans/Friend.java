package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Friend {
	@Id
	private String emailId;
	@ManyToOne
	private UserProfile user;
}
