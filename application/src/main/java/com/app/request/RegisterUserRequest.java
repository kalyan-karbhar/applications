package com.app.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	
	@NotNull
	private Integer userId;
	
	@NotNull
	@NotEmpty(message = "This field is not empty")
	private String userFirstName;
	

    private String userLastName;
    
	@NotNull
	@NotEmpty(message = "This field is not empty")
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
