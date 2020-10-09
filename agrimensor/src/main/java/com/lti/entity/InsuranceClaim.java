package com.lti.entity;
/**
 * @author Ruhi 
 * java version 1.8
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="InsuranceClaim")
@SequenceGenerator(name="insureclaimSeq", sequenceName = "insureclaim_seq11", initialValue = 1001, allocationSize = 1)

public class InsuranceClaim {
	@Id
	@GeneratedValue(generator = "insureclaimSeq",strategy = GenerationType.SEQUENCE)
	private int claimId;
	@Column
	private String claimReason;
	@Column
	private String dateOfLoss;
		
	/**
	 * @author YOJAN
	 * one to one relationship with Insurance
	 */
	@OneToOne
	@JoinColumn(name = "policyID")
	private Insurance insurance;
	
	public int getPolicyId() {
		return claimId;
	}
	public void setPolicyId(int policyId) {
		this.claimId = policyId;
	}
	
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public String getDateOfLoss() {
		return dateOfLoss;
	}
	public void setDateOfLoss(String dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}
//	public String getInsuranceClaimStatus() {
//		return insuranceClaimStatus;
//	}
//	public void setInsuranceClaimStatus(String insuranceClaimStatus) {
//		this.insuranceClaimStatus = insuranceClaimStatus;
//	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	/*
	 * { "claimReason":"Floods", "dateOfLoss":"12032020" }
	 */
	
	
}
