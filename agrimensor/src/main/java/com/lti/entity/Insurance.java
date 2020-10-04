package com.lti.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Insurance")
@SequenceGenerator(name="insuranceSeq", sequenceName = "insurance_seq", initialValue = 1001, allocationSize = 1)

public class Insurance {
	@Id
	@GeneratedValue(generator = "insuranceSeq",strategy = GenerationType.SEQUENCE)
	private int policyId;
//	@Column
//	private int policyNumber;
//	@Column
//	private int policyFarmerId;	
	
	private int policyCropId;
		
	/**
	 * @author YOJAN
	 */
	
//	@ManyToOne
//	@JoinColumn(name = "farmerId")
//	private Farmer farmerPolicy;
	
	@OneToOne(mappedBy = "insurance",cascade = CascadeType.ALL)
//	@JoinColumn(name="policyID")
	private InsuranceClaim claim;
	
	@Column(length=10)
	private String season;
	@Column
	private double sumPerHectare;
	private int policyCropArea;
	@Column(length =50)
	private String policyStatus;
	private double policySharedPremium;
	private double policyPremiumAmount;
	@Column(length=30)
	private String policyCompany;
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
//	public int getPolicyNumber() {
//		return policyNumber;
//	}
//	public void setPolicyNumber(int policyNumber) {
//		this.policyNumber = policyNumber;
//	}
//	public int getPolicyFarmerId() {
//		return policyFarmerId;
//	}
//	public void setPolicyFarmerId(int policyFarmerId) {
//		this.policyFarmerId = policyFarmerId;
//	}
	public int getPolicyCropId() {
		return policyCropId;
	}
	public void setPolicyCropId(int policyCropId) {
		this.policyCropId = policyCropId;
	}
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	public double getSumPerHectare() {
		return sumPerHectare;
	}
	public void setSumPerHectare(double sumPerHectare) {
		this.sumPerHectare = sumPerHectare;
	}
	public int getPolicyCropArea() {
		return policyCropArea;
	}
	public void setPolicyCropArea(int policyCropArea) {
		this.policyCropArea = policyCropArea;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public double getPolicySharedPremium() {
		return policySharedPremium;
	}
	public void setPolicySharedPremium(double policySharedPremium) {
		this.policySharedPremium = policySharedPremium;
	}
	public double getPolicyPremiumAmount() {
		return policyPremiumAmount;
	}
	public void setPolicyPremiumAmount(double policyPremiumAmount) {
		this.policyPremiumAmount = policyPremiumAmount;
	}
	public String getPolicyCompany() {
		return policyCompany;
	}
	public void setPolicyCompany(String policyCompany) {
		this.policyCompany = policyCompany;
	}
	
	/*
	 * public Farmer getFarmerPolicy() { return farmerPolicy; } public void
	 * setFarmerPolicy(Farmer farmerPolicy) { this.farmerPolicy = farmerPolicy; }
	 */
	public InsuranceClaim getClaim() {
		return claim;
	}
	public void setClaim(InsuranceClaim claim) {
		this.claim = claim;
	}
	


	
}
