package com.lti.entity;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
@SequenceGenerator(name="usersSeq", sequenceName = "users_seq", initialValue = 1001, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "usersSeq")
	@Column(name="user_id")
	private int userId;
	@Column(length=50, unique=true)
	private String emailId;
	@Column(length=32)
	private String password;
	@Column(length=10)
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		Decoder decoder= Base64.getDecoder();
		String decodedPass= new String(decoder.decode(password.getBytes()));
		return decodedPass;
	}
	public void setPassword(String password) {
		Encoder encoder= Base64.getEncoder();
		String encodedPass= encoder.encodeToString(password.getBytes());
		this.password = encodedPass;
	}

}
