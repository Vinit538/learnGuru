package com.learnGuru.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class learnGuruUser {
	
	@Id
	private String userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userRole;
	private String userPhoneNo;
	private String userDob;
	private int trainerSlno;
	private int studentSlno;
	
	public learnGuruUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public learnGuruUser(String userId, String userName, String userEmail, String userPassword, String userRole,
			String userPhoneNo, String userDob, int trainerSlno, int studentSlno) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userPhoneNo = userPhoneNo;
		this.userDob = userDob;
		this.trainerSlno = trainerSlno;
		this.studentSlno = studentSlno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserDob() {
		return userDob;
	}

	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}

	public int getTrainerSlno() {
		return trainerSlno;
	}

	public void setTrainerSlno(int trainerSlno) {
		this.trainerSlno = trainerSlno;
	}

	public int getStudentSlno() {
		return studentSlno;
	}

	public void setStudentSlno(int studentSlno) {
		this.studentSlno = studentSlno;
	}

	@Override
	public String toString() {
		return "learnGuruUser [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userRole=" + userRole + ", userPhoneNo=" + userPhoneNo
				+ ", userDob=" + userDob + ", trainerSlno=" + trainerSlno + ", studentSlno=" + studentSlno + "]";
	}
	
	
}
