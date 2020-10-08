package com.lti.repo;

public class Market {

	private Number bidder;
	private Number cropId;
	private String cropName;
	private String cropType;
	private Number currentBid;
	private Number basePrice;
	public Number getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Number basePrice) {
		this.basePrice = basePrice;
	}
	public Number getBidder() {
		return bidder;
	}
	public void setBidder(Number bidder) {
		this.bidder = bidder;
	}
	public Number getCropId() {
		return cropId;
	}
	public void setCropId(Number cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public Number getCurrentBid() {
		return currentBid;
	}
	public void setCurrentBid(Number currentBid) {
		this.currentBid = currentBid;
	}

}
