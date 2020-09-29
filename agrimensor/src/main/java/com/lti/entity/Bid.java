package com.lti.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
/**
 * @author Ruhi java version 1.8
 * for entity Bid
 */
@Entity
@Table(name="Bid")
@SequenceGenerator(name="bidSeq", sequenceName = "bid_seq", initialValue = 1001, allocationSize = 1)
/*
 * @NamedQuery(name = "UpdateBidStatus", query =
 * "UPDATE Bid SET bidStatus=:bidStatus WHERE bidId =: bidId ")
 */public class Bid {

	@Id
	@GeneratedValue(generator = "bidSeq",strategy = GenerationType.SEQUENCE)
	private int bidId;
	/*
	 * @Column private Date bidTime;
	 */
	private int bidCropId;
	private int bidBidderId;
	private double bidAmount;
	@Column(length = 10)
	private String bidStatus;
	
	//relation one-to-many for crop-bids entities
	@ManyToOne
	private Crop crop;
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	/*
	 * public Date getBidTime() { return bidTime; } public void setBidTime(Date
	 * bidTime) { this.bidTime = bidTime; }
	 */
	public int getBidCropId() {
		return bidCropId;
	}
	public void setBidCropId(int bidCropId) {
		this.bidCropId = bidCropId;
	}
	public int getBidBidderId() {
		return bidBidderId;
	}
	public void setBidBidderId(int bidBidderId) {
		this.bidBidderId = bidBidderId;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	
}
