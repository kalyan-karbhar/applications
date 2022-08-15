package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import com.app.response.ErrorResponse;
import com.app.services.RegisterUserService;
import com.aap.response.RegisterUserResponse;
import com.aap.response.UserDetail;
import com.aap.response.UserDetailResponse;
import com.app.constants.ApplicationConstant;
import com.app.constants.SwaggerConstant;
import com.app.entity.UserDetails;
import com.app.request.RegisterUserRequest;

@Slf4j
@RestController
public class RegisterUserController {
	Logger log = LoggerFactory.getLogger(RegisterUserController.class);
	
	private static final String USER_REGISER = "This URL is used to register the user";
	
	private static final String GET_ALL_USER = "This URL is used to get the all user details from DB";
	
	private static final String GET_USER = "This URL is used to get the user details from DB";
	
	@Autowired
	RegisterUserService registerUserService;
	
	@ApiOperation(value = GET_ALL_USER )
	@ApiImplicitParams({@ApiImplicitParam(name = ApplicationConstant.APPLICATION_VERSION,defaultValue =SwaggerConstant.SAMPLE_APPLICATION_VERSION,paramType = SwaggerConstant.SWAGER_REQUEST_HEADER),
		@ApiImplicitParam(name = ApplicationConstant.AUTHORIZATION_HEADER,defaultValue =SwaggerConstant.SAMPLE_ACCESS_TOKEN,paramType = SwaggerConstant.SWAGER_REQUEST_HEADER)})
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class),
			@ApiResponse(code = 409, message = "Conflict error", response = ErrorResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
	})
	@GetMapping(ApplicationConstant.VERSION+ApplicationConstant.USERS)
	public ResponseEntity<RegisterUserResponse> getAllRegisteredUsers(){
		log.info("Received the request to get the  all user from database");
		RegisterUserResponse response = new RegisterUserResponse();
		response.setUserDetail(registerUserService.getAllUsers());
		log.info("retruing response = {}",response);
		return new ResponseEntity<>(response ,HttpStatus.OK);
		}
	
	
	
	@ApiOperation(value = GET_USER )
	@ApiImplicitParams({@ApiImplicitParam(name = ApplicationConstant.APPLICATION_VERSION,defaultValue =SwaggerConstant.SAMPLE_APPLICATION_VERSION,paramType = SwaggerConstant.SWAGER_REQUEST_HEADER),
		@ApiImplicitParam(name = ApplicationConstant.AUTHORIZATION_HEADER,defaultValue =SwaggerConstant.SAMPLE_ACCESS_TOKEN,paramType = SwaggerConstant.SWAGER_REQUEST_HEADER)})
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class),
			@ApiResponse(code = 409, message = "Conflict error", response = ErrorResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
	})
	@GetMapping(ApplicationConstant.VERSION+ApplicationConstant.USERS+"/{userId}"+ApplicationConstant.USER)
	public ResponseEntity<UserDetailResponse> getRegisteredUser(@PathVariable Integer userId){
		log.info("Received the request to get the user from database with user id: {}",userId);
		UserDetailResponse response = new UserDetailResponse();
		response.setUserDetail(registerUserService.getUserById(userId));
		log.info("retruing response = {}",response);
		return new ResponseEntity<UserDetailResponse>(response ,HttpStatus.OK);
		}
	
}
