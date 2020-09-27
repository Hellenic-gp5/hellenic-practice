package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	private String adminUserName;
	private String adminPassword;
	//fields for approval status

	
}
