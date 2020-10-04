package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
@PrimaryKeyJoinColumn(name="userId", referencedColumnName = "user_id")
public class Admin extends User {
		//fields for approval status

	
}
