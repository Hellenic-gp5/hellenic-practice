package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * for entity Bid
 * 
 * @author Ruhi
 * @version 1.8
 */
@Entity
@Table(name = "Bids")
@SequenceGenerator(name = "bidsSeq", sequenceName = "bids_seq1", initialValue = 1001, allocationSize = 1)
/* @NamedQuery(name="getBidStatus", query="From Bid WHERE bidStatus=:crl") */
//@NamedQuery(name = "getBidsByBidder", query = "FROM Bid WHERE bidderId=:bidderId")
//@NamedQuery(name = "getBidsByCropId", query = "FROM Bid WHERE cropId=:cropId")
public class Bid {

	@Id
	@GeneratedValue(generator = "bidsSeq", strategy = GenerationType.SEQUENCE)
	private int bidId;
	@Column
	private int bidAmount;
//	@Column(length = 10)
//	private String bidStatus/* = "Queued" */;

	@ManyToOne
	private Bidder bidder;

	@ManyToOne
	private Crop crop;

	

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

//	public String getBidStatus() {
//		return bidStatus;
//	}
//
//	public void setBidStatus(String bidStatus) {
//		this.bidStatus = bidStatus;
//	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

}
