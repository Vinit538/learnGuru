package com.learnGuru.controller;

import java.time.Year;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learnGuru.entity.learnGuruUser;
import com.learnGuru.repository.UserRepository;
import com.learnGuru.services.userServices;

@Controller
public class userController {
	
	userServices us;
	
	UserRepository ur;


	
	public userController(userServices us, UserRepository ur) {
		super();
		this.us = us;
		this.ur = ur;
	}

	@PostMapping("/register")
	public ModelAndView addUser(@RequestParam("userName")String userName,
			@RequestParam("userEmail")String userEmail,
			@RequestParam("userPassword")String userPassword,
			@RequestParam("userRole")String userRole,
			@RequestParam("userPhoneNo")String userPhoneNo,
			@RequestParam("userDob")String userDob){
		
		boolean emailExits=us.checkuserEmail(userEmail);
		if(emailExits == false)
		{
			int laststslno =getstslno(userRole);
			int lasttrslno =gettrslno(userRole);
			learnGuruUser user = new learnGuruUser();
			String userId=getUserId(userRole,lasttrslno,laststslno);
			user.setUserId(userId);
			user.setUserName(userName);
			user.setUserEmail(userEmail);
			user.setUserDob(userDob);
			user.setUserPassword(userPassword);
			user.setUserRole(userRole);
			user.setTrainerSlno(lasttrslno);
			user.setStudentSlno(laststslno);
			us.addUser(user);
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("message", "Registered Sucessfully Now Login");
			return mv;

		} else {
			ModelAndView mv = new ModelAndView("register");
			mv.addObject("message", "Already Register With the Email" + userEmail);
			return mv;
		
		
	}
	}
	
	public Integer gettrslno(String userRole) {
        if (userRole.equals("trainer")) {
            Integer maxTrslno = ur.getMaxtrainerSlno();
            return (maxTrslno != null ? maxTrslno + 1 : 1);
        } else {
            return 0;
        }
    }
    
    public Integer getstslno(String userRole) {
        if (userRole.equals("student")) {
            Integer maxStslno = ur.getMaxstudentSlno();
            return (maxStslno != null ? maxStslno + 1 : 1);
        } else {
            return 0;
        }
    }
    
    
    public String getUserId(String userRole,int lasttrslno,int laststslno)
    {
    	 String year = String.valueOf(Year.now().getValue()).substring(2);
    	 String id="";
    	 if(userRole.equals("trainer"))
    		{
    		 	id="LG"+year+"TR"+lasttrslno;
    		}
    	 	else
    	 	{
    	 		 id="LG"+year+"ST"+laststslno;
    	 	}
    	return id;
    	
    }
	
}
