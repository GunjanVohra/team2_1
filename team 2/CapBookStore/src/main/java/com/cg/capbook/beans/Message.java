package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	private int messageId;
	private String messageBody;
	@ManyToOne
	private Chat chat;
	
	
}
