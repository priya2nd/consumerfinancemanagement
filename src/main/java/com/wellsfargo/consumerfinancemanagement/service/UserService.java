package com.wellsfargo.consumerfinancemanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.consumerfinancemanagement.model.User;
import com.wellsfargo.consumerfinancemanagement.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository urepo;
	
	public User registerUser(User user) {
		return urepo.save(user); // invoke jpa repository save() method
	}
	
	public User findUserByuserName(String userName) {
		return urepo.findUserByuName(userName);
	}

	public void updatePwdByuName(String userName, String password) {
		// TODO Auto-generated method stub
		urepo.updatePwdByuName(userName, password);
		System.out.println(userName + " " +  password);
	}
	
	public List<User> uDashboard() {
		// TODO Auto-generated method stub
		return urepo.uDashboard();
	}
	
	public User findPasswordByuserName(String userName) {
		return urepo.findPasswordByuName(userName);
	}
	
	public User findUserByEmail(String email) {
		System.out.println(urepo.findByEmail(email) + email);
		return urepo.findByEmail(email);
	}

	public String findUserByResetToken(String resetToken) {
		return urepo.findByResetToken(resetToken);
	}
	
	public void saveUser(User user) {
		urepo.save(user);
	}

	public void updateUserToken(String userToken) {
		urepo.updateUserToken(userToken);
		
	}

//	User getById(int id)
	
}
