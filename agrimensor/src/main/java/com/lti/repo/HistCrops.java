package com.lti.repo;

public class HistCrops {
	private Number cropId;
	private String cropName;
	private String cropType;
	private String fertilizer;
	private Number cropQuantity;
	private Number cropBasePrice;
	private Number cropSoldPrice;
	private String cropSoldStatus;

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public Number getCropId() {
		return cropId;
	}

	public void setCropId(Number cropId) {
		this.cropId = cropId;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public String getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(String cropFertilizer) {
		this.fertilizer = cropFertilizer;
	}

	public Number getQuantity() {
		return cropQuantity;
	}

	public void setQuantity(Number quantity) {
		cropQuantity = quantity;
	}

	public Number getCropBasePrice() {
		return cropBasePrice;
	}

	public void setCropBasePrice(Number cropBasePrice) {
		this.cropBasePrice = cropBasePrice;
	}

	public Number getCropSoldPrice() {
		return cropSoldPrice;
	}

	public void setCropSoldPrice(Number cropSoldPrice) {
		this.cropSoldPrice = cropSoldPrice;
	}

	public String getCropSoldStatus() {
		return cropSoldStatus;
	}

	public void setCropSoldStatus(String cropSoldStatus) {
		this.cropSoldStatus = cropSoldStatus;
	}

}
