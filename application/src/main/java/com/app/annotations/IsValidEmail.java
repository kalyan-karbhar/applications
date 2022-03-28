package com.app.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.constants.GloabalConstant;
import com.app.validator.EmailValidator;

/**
 *  IsValidEmail Annotation
 * @author Kalyan Karbhar
 *
 */
@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidEmail {
	String message() default "";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String format() default GloabalConstant.DEFAULT_EMAIL_REGEX;

}
