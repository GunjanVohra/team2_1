package com.cg.capbook.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.InvalidPasswordException;

@ControllerAdvice
public class CapbookExceptionAspect {
	@ExceptionHandler(InvalidEmailException.class)
	public ModelAndView handleInvalidEmailException(Exception e) {
		return new ModelAndView("registration", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ModelAndView handleInvalidPasswordException(Exception e) {
		return new ModelAndView("registration", "errorMessage", e.getMessage());
	}
}
