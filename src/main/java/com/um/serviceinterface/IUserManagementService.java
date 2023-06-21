package com.um.serviceinterface;

import com.um.dto.CredentialDto;
import com.um.dto.DashboardDto;
import com.um.dto.UserDto;

public interface IUserManagementService {
	
	public boolean login(CredentialDto credentialDto);
	
	public boolean forgotPass(String email);
	
	public UserDto profile(Long accId);
	
	public Long register(UserDto userDto);
	
	public DashboardDto dashBoard(Long accId);
}
