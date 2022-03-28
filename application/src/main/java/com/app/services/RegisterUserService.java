package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aap.response.UserDetail;
import com.app.request.RegisterUserRequest;

@Service
public interface RegisterUserService {
	/**
	 * This method is used to store the User details
	 * @param request
	 * @return
	 */
public List<UserDetail> saveUserDetail(RegisterUserRequest request);
}
