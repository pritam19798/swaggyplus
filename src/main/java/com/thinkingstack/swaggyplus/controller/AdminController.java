package com.thinkingstack.swaggyplus.controller;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkingstack.swaggyplus.Repository.AdminRepo;
import com.thinkingstack.swaggyplus.Resources.Admin;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminRepo.saveAndFlush(admin);
	}
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		System.out.println(admin);
		try{
			Admin byId=adminRepo.findById(admin.getAdminId()).get();
			if(byId.getPassword().equals(admin.getPassword())) {
				return new ResponseEntity<>(byId.getAdminId().toString() ,HttpStatus.OK);
			}else {
				return  new ResponseEntity<>("unauthorized",HttpStatus.UNAUTHORIZED);
			}
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
		}


        
	}

	@GetMapping("/getAdminName")
	public ResponseEntity<String> getUserName(@RequestParam String Id){
		
	   Admin name=adminRepo.findById(Long.parseLong(Id)).get();
	      return new ResponseEntity<>(name.getName(),HttpStatus.OK);
		
	}

}
