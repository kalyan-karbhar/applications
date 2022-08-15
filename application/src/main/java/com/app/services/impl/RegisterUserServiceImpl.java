package com.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aap.response.UserDetail;
import com.app.entity.UserDetails;
import com.app.repository.UserDetailsRepository;
import com.app.request.RegisterUserRequest;
import com.app.services.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public List<UserDetail> saveUserDetail(RegisterUserRequest request) {
    
		return null;
	}

	@Override
	public List<UserDetail> getAllUsers() {
		  List<UserDetail> userdetailsList = new ArrayList<>(); 
			
			List<UserDetails> userDetailList = userDetailsRepository.findAll();
			userDetailList.forEach(userdetail ->{
				UserDetail userDetail = new UserDetail();
				userDetail.setUserId(userdetail.getId());
				userDetail.setUserFirstName(userdetail.getFname());
				userDetail.setUserLastName(userdetail.getLname());
				userDetail.setEmail(userdetail.getEmail());
				userdetailsList.add(userDetail);
			});
			return userdetailsList;
	}
	
	@Override
	public Optional<UserDetails> getUserById(Integer userId) {
		return  userDetailsRepository.findById(userId);
	}

}
