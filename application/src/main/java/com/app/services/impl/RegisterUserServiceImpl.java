package com.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aap.response.UserDetail;
import com.app.request.RegisterUserRequest;
import com.app.services.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{

	@Override
	public List<UserDetail> saveUserDetail(RegisterUserRequest request) {
List<UserDetail> userdetailsList = new ArrayList<>(); 
		
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(request.getUserId());
		userDetail.setUserFirstName(request.getUserFirstName());
		userDetail.setUserLastName(request.getUserLastName());
		userDetail.setEmail(request.getEmail());
		
		userdetailsList.add(userDetail);
		return userdetailsList;
	}

}
