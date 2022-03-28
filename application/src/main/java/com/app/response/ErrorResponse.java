package com.app.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import com.app.error.ApiValidationError;;

@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ErrorResponse {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<ApiValidationError> apiValidationError = new HashSet<>();
	private String errorMessageCode ;
	
	public ErrorResponse(String errorMessageCode) {
		this.errorMessageCode = errorMessageCode;
	}
	
	public ErrorResponse(Set<ApiValidationError> apiValidationError,String errorMessageCode) {
		this.apiValidationError = apiValidationError;
		this.errorMessageCode = errorMessageCode;
	}
	
	public void addValidationError(ApiValidationError error ) {
		apiValidationError.add(error);
	}

}
