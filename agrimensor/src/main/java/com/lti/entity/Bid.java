package com.lti.entity;
import java.util.Date;

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
@Table(name="Bid")
@SequenceGenerator(name="bidSeq", sequenceName = "bid_seq", initialValue = 1001, allocationSize = 1)

public class Bid {

	@Id
	@GeneratedValue(generator = "bidSeq",strategy = GenerationType.SEQUENCE)
	private int bidId;
	@Column
	private Date bidTime;
	private int bidCropId;
	private int bidBidderId;
	private double bidAmount;
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
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
