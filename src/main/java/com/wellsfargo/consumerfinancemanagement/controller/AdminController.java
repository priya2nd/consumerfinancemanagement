package com.wellsfargo.consumerfinancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.consumerfinancemanagement.model.Admin;
import com.wellsfargo.consumerfinancemanagement.model.User;
import com.wellsfargo.consumerfinancemanagement.service.AdminService;
import com.wellsfargo.consumerfinancemanagement.service.UserService;

@RestController // generate & manage REST API in json format
@RequestMapping(value="/api")
public class AdminController {
	@Autowired
	private AdminService aservice;
	
	@Autowired
	private UserService uservice;
	
	
	/*POST - http://localhost:8082/consumerfinancemanagement/api/user */
	@PostMapping("/admin")		
	public Admin registerUser(@Validated @RequestBody Admin admin) {
		Admin a = new Admin();
		
		a.setAdminuName(admin.getAdminuName());
		a.setPassword(admin.getPassword());
		
		return aservice.registerUser(a); // invoke service method
	}
	
	@PostMapping(value = "/checkAdmin/{userName}")
	public String checkAdmin(@PathVariable("userName") String adminName, @RequestBody String password) {
		String pwd = aservice.findPasswordByadminName(adminName);
		if(pwd.equals(password))
			return("success");
		else
			return("failure");
	}
	
	@PostMapping(value = "/admin/dashboard")
	public List<User> dashBoard() {
		return uservice.uDashboard();
	}
	
	@PostMapping(value = "/admin/ActivationStatus/{userName}")
	public User updateActivationStatus(@PathVariable("userName") String userName, @RequestBody String response) {
		aservice.changeActStatus(userName, response);
		User u = uservice.findUserByuserName(userName);
		return u;
	}
}
