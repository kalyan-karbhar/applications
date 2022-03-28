package com.app.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.app.annotations.IsValidEmail;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import static com.app.error.ErrorType.Type.NOT_EMPTY;
import static com.app.error.ErrorType.Type.WRONG_FORMAT;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterUserRequest implements Serializable{
	
	private static final String FIELD_USER_ID = "userId";
	private static final String FIELD_USER_FIRSTNAME = "userFirstName";
	private static final String FIELD_USERLASTNAME = "userLastName";
	private static final String FIELD_EMAIL = "email";
	private static final String EMPTY_USER_FIRSTNAME = "empty-userFirstName";
	private static final String EMPTY_USER_LASTNAME = "empty-userLastName";
	private static final String EMPTY_EMAIL = "empty-email";
	
	@NotNull
	private Integer userId;
	
	@NotNull
	@NotEmpty(message = FIELD_USER_FIRSTNAME + ":" + EMPTY_USER_FIRSTNAME + ":" + NOT_EMPTY)
	private String userFirstName;
	

    private String userLastName;
    
	@NotNull
	@NotEmpty(message = FIELD_EMAIL + ":" + EMPTY_EMAIL + ":" + NOT_EMPTY)
	@IsValidEmail(message = FIELD_EMAIL + ":" + WRONG_FORMAT)
	private String email;
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return userLastName;
	}
	
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
