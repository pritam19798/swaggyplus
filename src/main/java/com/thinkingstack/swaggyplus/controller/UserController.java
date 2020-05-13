package com.thinkingstack.swaggyplus.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkingstack.swaggyplus.Repository.UserRepo;
import com.thinkingstack.swaggyplus.Resources.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userRepo.saveAndFlush(user);
	}
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody User user) {
		try{
			User byId=userRepo.findById(user.getUserId()).get();
			if(byId.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>("okay" ,HttpStatus.OK);
			}else {
				return  new ResponseEntity<>("unauthorized",HttpStatus.UNAUTHORIZED);
			}
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
		}
	}
}
