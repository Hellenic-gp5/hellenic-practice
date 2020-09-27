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
 * for entity BIDDER
 */

@Entity
@Table(name="Bidder")
@SequenceGenerator(name="bidderSeq", sequenceName = "bidder_seq", initialValue = 1001, allocationSize = 1)

public class Bidder {

	@Id
	@GeneratedValue(generator = "bidderSeq",strategy = GenerationType.SEQUENCE)
	private int bidderId;
	@Column(length=30)
	private String bidderName;
	@Column
	private String bidderEmail;
	@Column
	private String bidderAddressLine1;
	@Column
	private String bidderAddressLine2;
	@Column
	private String bidderCity;
	@Column
	private String bidderState;
	@Column
	private long bidderPAN;
	@Column
	private int bidderPIN;
	@Column
	private long bidderAADHAR;
	@Column
	private String bidderIFSC;
	@Column
	private long bidderAccountNumber;
	@Column
	private String bidderPassword;
	@Column
	private String bidderLicense;
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	public String getBidderEmail() {
		return bidderEmail;
	}
	public void setBidderEmail(String bidderEmail) {
		this.bidderEmail = bidderEmail;
	}
	public String getBidderAddressLine1() {
		return bidderAddressLine1;
	}
	public void setBidderAddressLine1(String bidderAddressLine1) {
		this.bidderAddressLine1 = bidderAddressLine1;
	}
	public String getBidderAddressLine2() {
		return bidderAddressLine2;
	}
	public void setBidderAddressLine2(String bidderAddressLine2) {
		this.bidderAddressLine2 = bidderAddressLine2;
	}
	public String getBidderCity() {
		return bidderCity;
	}
	public void setBidderCity(String bidderCity) {
		this.bidderCity = bidderCity;
	}
	public String getBidderState() {
		return bidderState;
	}
	public void setBidderState(String bidderState) {
		this.bidderState = bidderState;
	}
	public long getBidderPAN() {
		return bidderPAN;
	}
	public void setBidderPAN(long bidderPAN) {
		this.bidderPAN = bidderPAN;
	}
	public int getBidderPIN() {
		return bidderPIN;
	}
	public void setBidderPIN(int bidderPIN) {
		this.bidderPIN = bidderPIN;
	}
	public long getBidderAADHAR() {
		return bidderAADHAR;
	}
	public void setBidderAADHAR(long bidderAADHAR) {
		this.bidderAADHAR = bidderAADHAR;
	}
	public String getBidderIFSC() {
		return bidderIFSC;
	}
	public void setBidderIFSC(String bidderIFSC) {
		this.bidderIFSC = bidderIFSC;
	}
	public long getBidderAccountNumber() {
		return bidderAccountNumber;
	}
	public void setBidderAccountNumber(long bidderAccountNumber) {
		this.bidderAccountNumber = bidderAccountNumber;
	}
	public String getBidderPassword() {
		return bidderPassword;
	}
	public void setBidderPassword(String bidderPassword) {
		this.bidderPassword = bidderPassword;
	}
	public String getBidderLicense() {
		return bidderLicense;
	}
	public void setBidderLicense(String bidderLicense) {
		this.bidderLicense = bidderLicense;
	}
	
	
}
