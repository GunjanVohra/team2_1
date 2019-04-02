package com.cg.capbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cg.capbook.beans.UserProfile;

@Controller
@SessionAttributes("user")
public class URIController {

	private UserProfile user;

	@RequestMapping("/")
	public String getRegistrationPage() {
		return "registration";
	}

	@RequestMapping("/forgotPasswordPage")
	public String getForgotPasswordPage() {
		return "forgotPasswordPage";
	}
	@RequestMapping("/profilePage")
	public String getProfilePage() {
		return "profilePage";
	}
	@RequestMapping("/profileEditPage")
	public String getProfileEditPage() {
		return "profileEditPage";
	}
	@ModelAttribute("user")
	public UserProfile getUser() {
		user= new UserProfile();
		return user;
	}
}
