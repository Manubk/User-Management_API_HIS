package com.um.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CASE_WORKER_ACC")
public class UserEntity extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_ID")
	private Long accId;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PWD")
	private String pass;
	
	@Column(name = "PHONE_NO")
	private String phoneNo;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "SSN")
	private String ssn;
	
	@Column(name = "DOB")
	private LocalDate dob;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
}

