package com.cg.capbook.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.cg.capbook.beans.Image;
import com.cg.capbook.beans.UserProfile;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.WrongSecurityAnswerException;
import com.cg.capbook.services.ImageService;
import com.cg.capbook.services.UserProfileService;

@Controller
@SessionAttributes("user")
public class CapbookServiceController {
	private UserProfile user;
	@Autowired
	private UserProfileService userProfileService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/registrationForm")
	public ModelAndView registerUser(@Valid@ModelAttribute UserProfile user) {
		user=userProfileService.registerUser(user);
		return new ModelAndView("profilePage","user",user);
	}
	
	@RequestMapping("/login")
	public ModelAndView loginUser(@Valid@RequestParam String emailId, @Valid@RequestParam String password) throws InvalidEmailException, InvalidPasswordException {
		user=userProfileService.loginUser(emailId, password);
		return new ModelAndView("profilePage","user",user);
	}
	
	@RequestMapping("/profileEdit")
	public ModelAndView editUser(@RequestParam("file") MultipartFile file,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String dob,@RequestParam String city,@RequestParam String state,@RequestParam String country,@RequestParam int zipCode,@SessionAttribute("user") UserProfile user) throws InvalidEmailException, InvalidPasswordException {
		user=userProfileService.editUser(user,firstName,lastName,dob,city,state,country,zipCode,file);
		return new ModelAndView("profileEditPage","user",user);
	}
	
	@RequestMapping("/forgotPasswordSecurity")
	public ModelAndView forgotPasswordSecurityQues(@Valid@RequestParam String emailId) throws InvalidEmailException {
		user=userProfileService.getUserDetails(emailId);
		return new ModelAndView("forgotPasswordPage","user",user);
	}
	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword(@RequestParam String securityAnswer,@Valid@RequestParam String emailId) throws InvalidEmailException, WrongSecurityAnswerException {
		user=userProfileService.getUserDetails(emailId);
		String answer=user.getSecurityAnswer();
		if(answer.equals(securityAnswer))
		{
			String password=user.getPassword();
			String passwordDecrypt=userProfileService.decryptPassword(password);
			return new ModelAndView("forgotPasswordPage","password",passwordDecrypt);
		}
		else throw new WrongSecurityAnswerException("Answer is incorrect");	
	}
	
	@PostMapping("/uploadFile")
    public Image uploadFile(@SessionAttribute("user") UserProfile user,@RequestParam("file") MultipartFile file,String albumName) {
        
		Image image=imageService.addAlbum(file, user,albumName);
         return image;
    }
	
	@PostMapping("/multiplePhoto")
    public List<Image> uploadMultipleFiles(@SessionAttribute("user") UserProfile user,@RequestParam("files") MultipartFile[] files,String albumName) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(user,file,albumName))
                .collect(Collectors.toList());
    }
}
