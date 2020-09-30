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
@SequenceGenerator(name="insureclaimSeq", sequenceName = "insureclaim_seq", initialValue = 1001, allocationSize = 1)

public class InsuranceClaim {
	@Id
	@GeneratedValue(generator = "insureclaimSeq",strategy = GenerationType.SEQUENCE)
	private int policyId;
	@Column(length=30)
	private String policyCompany;
	@Column
	private String claimReason;
	@Column
	private Date dateOfLoss;
	@Column(length=10)
	private String insuranceClaimStatus;
	
	/**
	 * @author YOJAN
	 */
	@OneToOne
	@JoinColumn(name = "policyID")
	private Insurance insurance;
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyCompany() {
		return policyCompany;
	}
	public void setPolicyCompany(String policyCompany) {
		this.policyCompany = policyCompany;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public Date getDateOfLoss() {
		return dateOfLoss;
	}
	public void setDateOfLoss(Date dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}
	public String getInsuranceClaimStatus() {
		return insuranceClaimStatus;
	}
	public void setInsuranceClaimStatus(String insuranceClaimStatus) {
		this.insuranceClaimStatus = insuranceClaimStatus;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
}
