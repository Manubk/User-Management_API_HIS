package com.um.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.constants.AppContants;
import com.um.dto.CredentialDto;
import com.um.dto.DashboardDto;
import com.um.dto.MailRequirments;
import com.um.dto.UserDto;
import com.um.entity.UserEntity;
import com.um.repo.UserEntityRepo;
import com.um.serviceinterface.IUserManagementService;
import com.um.util.Util;

@Service
public class UserManagementService implements IUserManagementService{
	
	
	private static final Logger log = LoggerFactory.getLogger(UserManagementService.class);

	@Autowired
	private UserEntityRepo userRepo;
	
	@Autowired
	private Util util;
	
	@Override
	public boolean login(CredentialDto credentialDto) {
		log.info("login email = "+credentialDto.getEmail());
		
		UserEntity user = userRepo.findByEmail(credentialDto.getEmail());
		
		if(user != null && user.getPass().equals(credentialDto.getPass()))
			return true;
		
		return false;
	}

	@Override
	public boolean forgotPass(String email) {
		log.info("forgotPass email = "+email);
		
		UserEntity user = userRepo.findByEmail(email);
		
		if(user == null)
			return false;
		
		return util.sendMail(createMail(user));
	}

	@Override
	public UserDto profile(Long accId) {
		log.info("profile");
		 
		Optional<UserEntity> OUser = userRepo.findById(accId);
		
		if(OUser.isPresent()) {
			UserEntity user = OUser.get();
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			
			log.info(userDto.toString());
			
			return userDto;
		}
			
		return null;
	}

	@Override
	public Long register(UserDto userDto) {
		log.info("Register");
		
		//TODO 
		
		return null;
	}

	@Override
	public DashboardDto dashBoard(Long accId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private MailRequirments createMail(UserEntity user) {
		log.info("CreateMail");
		MailRequirments mail = new MailRequirments();
		
		String subject = AppContants.FORGOT_PASS;
		String body = AppContants.MAIL_BODY;
		body = body.replaceAll("USERNAME", user.getFullName());
		body.replaceAll("PASSWORD",user.getPass());
		
		mail.setFrom(AppContants.FROM_MAIL);
		mail.setTo(user.getEmail());
		mail.setSubject(subject);
		mail.setBody(body);
		
		return mail;
	}

}
