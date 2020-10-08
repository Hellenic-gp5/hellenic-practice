package com.lti.repo;

public class ReturnCrop {
	private Number cropId;
	private Number cropBasePrice;
	private String cropName;
	private String cropType;
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	private String fertilizer;
	private String soilPH;
	public Number getCropId() {
		return cropId;
	}
	public void setCropId(Number cropId) {
		this.cropId = cropId;
	}
	public Number getCropBasePrice() {
		return cropBasePrice;
	}
	public void setCropBasePrice(Number cropBasePrice) {
		this.cropBasePrice = cropBasePrice;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}
	public String getSoilPH() {
		return soilPH;
	}
	public void setSoilPH(String soilPH) {
		this.soilPH = soilPH;
	}
	

}
