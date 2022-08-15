package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aap.response.UserDetail;
import com.app.entity.UserDetails;
import com.app.request.RegisterUserRequest;

@Service
public interface RegisterUserService {
	/**
	 * This method is used to store the User details
	 * @param request
	 * @return
	 */
public List<UserDetail> saveUserDetail(RegisterUserRequest request);

/**
 * This method return all the user present in database
 * @return
 */
public List<UserDetail> getAllUsers();

/**
 * This method return the user details based on user id
 * @return
 */

public Optional<UserDetails> getUserById(Integer userId);
}
