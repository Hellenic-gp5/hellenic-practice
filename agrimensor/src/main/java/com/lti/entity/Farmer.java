package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @author Ruhi java version 1.8
 * for entity FARMER
 */
@Entity
@Table(name="Farmer")
@SequenceGenerator(name="farmerSeq", sequenceName = "farmer_seq", initialValue = 1001, allocationSize = 1)

public class Farmer {
	
	@Id
	@GeneratedValue(generator = "farmerSeq",strategy = GenerationType.SEQUENCE)
	private int farmerId;
	@Column(length=30)
	private String farmerName;
	@Column
	private String farmerEmail;
	@Column
	private String farmerAddressLine1;
	@Column
	private String farmerAddressLine2;
	@Column
	private String farmerCity;
	@Column
	private String farmerState;
	@Column
	private String farmerPAN;
	@Column
	private String farmerCertificate;
	@Column
	private int farmerPINCode;
	@Column
	private String farmerAADHAR;
	@Column
	private String farmerIFSC;
	@Column
	private long farmerAccountNumber;
	@Column
	private String farmerPassword;
	@Column
	private String farmerLandAddress;
	@Column
	private String farmerLandPIN;
	@Column
	private String farmerLandArea;
	
	public String getFarmerCertificate() {
		return farmerCertificate;
	}
	public void setFarmerCertificate(String farmerCertificate) {
		this.farmerCertificate = farmerCertificate;
	}
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	public String getFarmerAddressLine1() {
		return farmerAddressLine1;
	}
	public void setFarmerAddressLine1(String farmerAddressLine1) {
		this.farmerAddressLine1 = farmerAddressLine1;
	}
	public String getFarmerAddressLine2() {
		return farmerAddressLine2;
	}
	public void setFarmerAddressLine2(String farmerAddressLine2) {
		this.farmerAddressLine2 = farmerAddressLine2;
	}
	public String getFarmerCity() {
		return farmerCity;
	}
	public void setFarmerCity(String farmerCity) {
		this.farmerCity = farmerCity;
	}
	public String getFarmerState() {
		return farmerState;
	}
	public void setFarmerState(String farmerState) {
		this.farmerState = farmerState;
	}
	public String getFarmerPAN() {
		return farmerPAN;
	}
	public void setFarmerPAN(String farmerPAN) {
		this.farmerPAN = farmerPAN;
	}
	public int getFarmerPINCode() {
		return farmerPINCode;
	}
	public void setFarmerPINCode(int farmerPINCode) {
		this.farmerPINCode = farmerPINCode;
	}
	public String getFarmerAADHAR() {
		return farmerAADHAR;
	}
	public void setFarmerAADHAR(String farmerAADHAR) {
		this.farmerAADHAR = farmerAADHAR;
	}
	public String getFarmerIFSC() {
		return farmerIFSC;
	}
	public void setFarmerIFSC(String farmerIFSC) {
		this.farmerIFSC = farmerIFSC;
	}
	public long getFarmerAccountNumber() {
		return farmerAccountNumber;
	}
	public void setFarmerAccountNumber(long farmerAccountNumber) {
		this.farmerAccountNumber = farmerAccountNumber;
	}
	public String getFarmerPassword() {
		return farmerPassword;
	}
	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}
	public String getFarmerLandAddress() {
		return farmerLandAddress;
	}
	public void setFarmerLandAddress(String farmerLandAddress) {
		this.farmerLandAddress = farmerLandAddress;
	}
	public String getFarmerLandPIN() {
		return farmerLandPIN;
	}
	public void setFarmerLandPIN(String farmerLandPIN) {
		this.farmerLandPIN = farmerLandPIN;
	}
	public String getFarmerLandArea() {
		return farmerLandArea;
	}
	public void setFarmerLandArea(String farmerLandArea) {
		this.farmerLandArea = farmerLandArea;
	}
	
	


}
