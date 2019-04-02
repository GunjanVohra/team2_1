package com.cg.capbook.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Chat {
	@Id
	private int chatId;
	private String receiverEmail;
	@OneToMany(mappedBy="chat")
	@MapKey
	private List<Message>messages;
	@ManyToOne
	private UserProfile user;
	
}
