package com.lti.repo;

import org.springframework.stereotype.Component;


public class CropBid {
private Number bidderId;
private Number bidAmount;
private Number bidId;
public Number getBidderId() {
	return bidderId;
}
public void setBidderId(Number bidderId) {
	this.bidderId = bidderId;
}
public Number getBidAmount() {
	return bidAmount;
}
public void setBidAmount(Number bidAmount) {
	this.bidAmount = bidAmount;
}
public Number getBidId() {
	return bidId;
}
public void setBidId(Number bidId) {
	this.bidId = bidId;
}


}
