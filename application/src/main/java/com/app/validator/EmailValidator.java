package com.app.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.annotations.IsValidEmail;
import com.app.constants.GloabalConstant;

public class EmailValidator implements ConstraintValidator<IsValidEmail, Object>{

	private IsValidEmail isValidEmail;
	
	@Override
	public void initialize(IsValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		this.isValidEmail = constraintAnnotation;
	}
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		List<String> emailAddresses = null;
		Pattern pattern;
		Matcher matcher;
		if(value == null ) {
			return true;
		}
		if(value instanceof List) {
			if(((List)value).size() == 0) {
				return false;
			}
			emailAddresses = (List<String>) value;
		}else if(value instanceof String && !((String) value).isEmpty() ) {
			emailAddresses.add((String) value);
		}
		
		String emailRegx = GloabalConstant.DEFAULT_EMAIL_REGEX;
		if(emailRegx != null && !emailRegx.isEmpty()) {
			pattern = Pattern.compile(emailRegx);
			for(String emailAddress : emailAddresses){
				matcher = pattern.matcher(emailAddress);
				if(!matcher.matches()) {
					return false;
				}
			}
		}
		return false;
	}

}
