package com.learnGuru.services;

import com.learnGuru.entity.learnGuruUser;

public interface userServices {
	//to add new user
		String addUser(learnGuruUser user);
		
		learnGuruUser getUser(String userEmail);
		//to check the userEmail exits or not
		boolean checkuserEmail(String userEmail);
		//validates user's credentials
		boolean validate(String userEmail, String userPassword); 
		// get userRole
		String getUsersRole(String userEmail);
		
		learnGuruUser getTrainer(String userEmail);

}
