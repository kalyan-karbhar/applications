package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.app.response.ErrorResponse;
import com.app.services.RegisterUserService;
import com.aap.response.RegisterUserResponse;
import com.aap.response.UserDetail;
import com.app.constants.ApplicationConstant;
import com.app.request.RegisterUserRequest;

@RestController
public class RegisterUserController {

	private static final String USER_REGISER = "This URL is used to register the user";
	
	@Autowired
	RegisterUserService registerUserService;
	
	@ApiOperation(value = USER_REGISER )
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class),
			@ApiResponse(code = 409, message = "Conflict error", response = ErrorResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
	})
	@PostMapping(ApplicationConstant.VERSION+ApplicationConstant.USERS)
	public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody @Valid RegisterUserRequest request){
		
		RegisterUserResponse response = new RegisterUserResponse();
		response.setUserDetail(registerUserService.saveUserDetail(request));
		return new ResponseEntity<>(response ,HttpStatus.OK);
		
	}
}
