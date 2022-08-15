package com.aap.response;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.app.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class UserDetailResponse implements Serializable {
	
	@JsonProperty(value = "user-detail")
	Optional<UserDetails> userDetail ;

	public Optional<UserDetails> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(Optional<UserDetails> userDetail) {
		this.userDetail = userDetail;
	}
	
	
}
