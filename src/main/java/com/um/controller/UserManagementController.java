package com.um.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.um.constants.AppContants;
import com.um.dto.CredentialDto;
import com.um.dto.DashboardDto;
import com.um.dto.UserDto;
import com.um.entity.UserEntity;
import com.um.serviceinterface.IUserManagementService;

@CrossOrigin
@RestController
public class UserManagementController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

	@Autowired
	private IUserManagementService userManagementService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody CredentialDto credentialDto){
		log.info("login email = "+credentialDto.getEmail());
		
		boolean isLogin = userManagementService.login(credentialDto);
		
		return (isLogin)?new ResponseEntity<String>(AppContants.LOGIN_SUCESS,HttpStatus.ACCEPTED):
			new ResponseEntity<String>(AppContants.LOGIN_FAILED,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/forgotpass/{email}")
	public ResponseEntity<String> forgotPass(String email){
		log.info("forgotpass email = "+email);
		
		boolean isForgotPass = userManagementService.forgotPass(email);
		
		return (isForgotPass)?new ResponseEntity<String>(AppContants.SUCESSFUL,HttpStatus.ACCEPTED):
			new ResponseEntity<String>(AppContants.NO_USER_PRESENT+email,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/profile/{accId}")
	public ResponseEntity<UserDto> profile(Long accId){
		log.info("profile accId = "+accId);
		
		UserDto userDto = userManagementService.profile(accId);
		
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	
	@GetMapping("/dashboard/{accId}")
	public ResponseEntity<DashboardDto> dashboard(Long accId){
		log.info("dashboard accId = "+accId);
		
		//TODO logi for dachboard
		
		return null;
	}
}
