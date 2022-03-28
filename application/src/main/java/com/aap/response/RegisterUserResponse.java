package com.aap.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegisterUserResponse implements Serializable {

	@JsonProperty(value = "user-detail")
	List<UserDetail> userDetail ;

	public List<UserDetail> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(List<UserDetail> userDetail) {
		this.userDetail = userDetail;
	}
	
	
}
