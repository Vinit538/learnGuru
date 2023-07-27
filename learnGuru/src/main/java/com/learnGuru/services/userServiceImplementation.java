package com.learnGuru.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.learnGuru.entity.learnGuruUser;
import com.learnGuru.repository.UserRepository;

public class userServiceImplementation implements userServices {

	@Autowired
	UserRepository userRepo;

	public userServiceImplementation(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public String addUser(learnGuruUser user) {
		userRepo.save(user);
		return "Registeration Done";
	}

	@Override
	public learnGuruUser getUser(String userEmail) {
		return userRepo.findByUserEmail(userEmail);
	}

	@Override
	public boolean checkuserEmail(String userEmail) {

		return userRepo.existsByuserEmail(userEmail);
	}

	@Override
	public boolean validate(String userEmail, String userPassword) {
		if (userRepo.existsByuserEmail(userEmail)) {
			learnGuruUser user = userRepo.getByuserEmail(userEmail);
			String dbPassword = user.getUserPassword();
			if (userPassword.equals(dbPassword)) {
				return true;
			} else {
				return false;
			}
		} else {

			return false;
		}
	}

	@Override
	public String getUsersRole(String userEmail) {
		learnGuruUser user=userRepo.getByuserEmail(userEmail);
		return user.getUserRole();
	}

	@Override
	public learnGuruUser getTrainer(String userEmail) {
		learnGuruUser user=userRepo.getByuserEmail(userEmail);
		return user;
	}

}
