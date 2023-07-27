package com.learnGuru.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learnGuru.entity.learnGuruUser;

public interface UserRepository extends JpaRepository<learnGuruUser, String>{
	
	//to check the whether user email is present or not 
	boolean existsByuserEmail(String userEmail);

	learnGuruUser getByuserEmail(String userEmail);
	
	@Query("SELECT MAX(cu.cuslno) FROM Course cu")
	int findMaxcuslno();
	
	learnGuruUser findByUserEmail(String userEmail);
	
	
	
	@Query("SELECT MAX(userslno.trainerSlno) FROM learnGuruUser userslno")
    int getMaxtrainerSlno();

	@Query("SELECT MAX(userslno.studentSlno) FROM learnGuruUser userslno")
    int getMaxstudentSlno();

}
