package com.lti.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
@Table(name="Bidder")

/**
 * @author YOJAN Java version 1.8
 * Join table with User as base and secondary tables for basic info and documents
 */
@PrimaryKeyJoinColumn(name="bidderid", referencedColumnName = "user_id")
@SecondaryTables({@SecondaryTable(name="bidder_doc"),@SecondaryTable(name="bidder_info")})
@SequenceGenerator(name="bidderSeq", sequenceName = "bidder_seq", initialValue = 1001, allocationSize = 1)

public class Bidder extends User {

//	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "bidderSeq")
	
	//private int bidderId;
	@Column(length=30)
	private String bidderName;
	//	@Column(length=50)
	//	private String bidderEmail;

	@Column(length = 30, table="bidder_info")
	private String bidderAddressLine1;

	@Column(length = 30, table="bidder_info")
	private String bidderAddressLine2;

	@Column(length=25, table="bidder_info")
	private String bidderCity;

	@Column(length=25, table="bidder_info")
	private String bidderState;

	@Column(length=30, table="bidder_doc")
	private String bidderPAN;

	@Column(length=7, table="bidder_info")
	private int bidderPINCODE;

	@Column(length=30, table="bidder_doc")
	private String bidderAADHAR;

	@Column(length=25, table="bidder_info")
	private String bidderIFSC;

	@Column(table ="bidder_info")
	private String bidderAccountNumber;

	@Column(length=30, table="bidder_doc")
	private String bidderLicense;

	@Column(length=15, table="bidder_info")
	private String bidderStatus;
	/**
	 * @author Sakshi
	 *Many to many relation with crop
	 */
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="bidder_crop",
	joinColumns= {@JoinColumn(name="bidderId")},
	inverseJoinColumns= {@JoinColumn(name="cropId")})
	@JsonIgnore
	private List<Crop>crop = new ArrayList<Crop>();

	@OneToMany(mappedBy = "bidderId",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Bid>bids=new ArrayList<Bid>();

	public String getBidderStatus() {
		return bidderStatus;
	}
	public void setBidderStatus(String bidderStatus) {
		this.bidderStatus = bidderStatus;
	}
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	public List<Crop> getCrop() {
		return crop;
	}
	public void setCrop(List<Crop> crop) {
		this.crop = crop;
	}
//	public int getBidderId() {
//		return bidderId;
//	}
//	public void setBidderId(int bidderId) {
//		this.bidderId = bidderId;
//	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	//	public String getBidderEmail() {
	//		return bidderEmail;
	//	}
	//	public void setBidderEmail(String bidderEmail) {
	//		this.bidderEmail = bidderEmail;
	//	}
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
	public String getBidderPAN() {
		return bidderPAN;
	}
	public void setBidderPAN(String bidderPAN) {
		this.bidderPAN = bidderPAN;
	}
	public int getBidderPINCODE() {
		return bidderPINCODE;
	}
	public void setBidderPINCODE(int bidderPINCODE) {
		this.bidderPINCODE = bidderPINCODE;
	}
	public String getBidderAADHAR() {
		return bidderAADHAR;
	}
	public void setBidderAADHAR(String bidderAADHAR) {
		this.bidderAADHAR = bidderAADHAR;
	}
	public String getBidderIFSC() {
		return bidderIFSC;
	}
	public void setBidderIFSC(String bidderIFSC) {
		this.bidderIFSC = bidderIFSC;
	}
	public String getBidderAccountNumber() {
		return bidderAccountNumber;
	}
	public void setBidderAccountNumber(String bidderAccountNumber) {
		this.bidderAccountNumber = bidderAccountNumber;
	}
	//	public String getBidderPassword() {
	//		return bidderPassword;
	//	}
	//	public void setBidderPassword(String bidderPassword) {
	//		this.bidderPassword = bidderPassword;
	//	}
	public String getBidderLicense() {
		return bidderLicense;
	}
	public void setBidderLicense(String bidderLicense) {
		this.bidderLicense = bidderLicense;
	}


}
