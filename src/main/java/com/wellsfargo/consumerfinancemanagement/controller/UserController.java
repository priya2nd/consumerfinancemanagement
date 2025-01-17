package com.wellsfargo.consumerfinancemanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.consumerfinancemanagement.model.User;
import com.wellsfargo.consumerfinancemanagement.service.UserService;

@RestController // generate & manage REST API in json format
@RequestMapping(value="/api")
public class UserController {

	@Autowired
	private UserService uservice;
	
	
	/*POST - http://localhost:8082/consumerfinancemanagement/api/user */
	@PostMapping("/user")		
	public User registerUser(@Validated @RequestBody User user) {
		User u1=new User();

		u1.setName(user.getName());
		u1.setPhoneNo(user.getPhoneNo());
		u1.setEmailId(user.getEmailId());
		u1.setUserName(user.getUserName());
		u1.setPassword(user.getPassword());
		u1.setAddress(user.getAddress());
		u1.setCardType(user.getCardType());
		u1.setBank(user.getBank());
		u1.setIfscCode(user.getIfscCode());
		u1.setAccountNo(user.getAccountNo());
		u1.setDocUpload(user.getDocUpload());
		u1.setActvnStatus("Pending");
		
		return uservice.registerUser(u1); // invoke service method
	}
	
	
	@GetMapping(value = "/find/{userName}")
	public User changePassword(@PathVariable("userName") String userName) {
		User u = uservice.findUserByuserName(userName);
		return u;
	}
	
	@PostMapping(value = "/checkUser/{userName}")
	public String checkUser(@PathVariable("userName") String userName, @RequestBody String password) {
		String pwd = uservice.findPasswordByuserName(userName);
		if(pwd.equals(password))
			return("success");
		else
			return("failure");
	}
	
	@PostMapping(value = "/updatePassword/{userName}")
	public User updatePassword(@PathVariable("userName") String userName, @RequestBody String password) {
		System.out.println(userName + " " +  password);
		uservice.updatePwdByuName(userName, password);
		User u = uservice.findUserByuserName(userName);
		return u;
	}
}
