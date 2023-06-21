package com.um.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {
	
	private Long accId;
	
	private String email;
	
	private String phoneNo;
	
	private String gender;
	
	private String ssn;
	
	private LocalDate dob;

}
