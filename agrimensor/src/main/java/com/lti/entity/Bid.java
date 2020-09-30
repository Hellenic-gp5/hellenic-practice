package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * for entity Bid
 * 
 * @author Ruhi
 * @version 1.8
 */
@Entity
@Table(name = "Bid")
@SequenceGenerator(name = "bidSeq", sequenceName = "bid_seq", initialValue = 1001, allocationSize = 1)
@NamedQuery(name = "getBidStatus", query = "FROM Bid WHERE bidStatus=:crl")
@NamedQuery(name = "getBidsByBidder", query = "FROM Bid WHERE bidderId=:bidderId")
@NamedQuery(name = "getBidsByCropId", query = "FROM Bid WHERE cropId=:cropId")
public class Bid {

	@Id
	@GeneratedValue(generator = "bidSeq", strategy = GenerationType.SEQUENCE)
	private int bidId;
	@Column
	private double bidAmount;
	@Column(length = 10)
	private String bidStatus = "Queued";

	@ManyToOne
	@JoinColumn(name = "bidderId")
	private Bidder bidderId;

	@ManyToOne
	@JoinColumn(name = "cropId")
	private Crop cropId;

	public Crop getCropId() {
		return cropId;
	}

	public void setCropId(Crop cropId) {
		this.cropId = cropId;
	}

	public Bidder getBidder() {
		return bidderId;
	}

	public void setBidder(Bidder bidderId) {
		this.bidderId = bidderId;
	}

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

	public Bidder getBidderId() {
		return bidderId;
	}

	public void setBidderId(Bidder bidderId) {
		this.bidderId = bidderId;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

}
