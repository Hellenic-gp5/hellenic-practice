package com.lti.entity;
/**
 * @author Ruhi java version 1.8
 *
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Crop")
@SequenceGenerator(name="cropSeq", sequenceName = "crop_seq", initialValue = 1001, allocationSize = 1)

public class Crop {
	@Id
	@GeneratedValue(generator = "cropSeq",strategy = GenerationType.SEQUENCE)
	private int cropId;
	@Column(length=30)
	private String cropName;
	@Column
	private String cropType;
	@Column
	private String fertilizer;
	@Column
	private double cropBasePrice;
	@Column
	private double cropSoldPrice;
	@Column
	private Date cropSoldDate;
	@Column
	private int cropQuantity;
	@Column(length = 10)
	private String cropSoldStatus;
	@Column
	private String soilPH;
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
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
	public String getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}
	public double getCropBasePrice() {
		return cropBasePrice;
	}
	public void setCropBasePrice(double cropBasePrice) {
		this.cropBasePrice = cropBasePrice;
	}
	public double getCropSoldPrice() {
		return cropSoldPrice;
	}
	public void setCropSoldPrice(double cropSoldPrice) {
		this.cropSoldPrice = cropSoldPrice;
	}
	public Date getCropSoldDate() {
		return cropSoldDate;
	}
	public void setCropSoldDate(Date cropSoldDate) {
		this.cropSoldDate = cropSoldDate;
	}
	public int getCropQuantity() {
		return cropQuantity;
	}
	public void setCropQuantity(int cropQuantity) {
		this.cropQuantity = cropQuantity;
	}
	public String getCropSoldStatus() {
		return cropSoldStatus;
	}
	public void setCropSoldStatus(String cropSoldStatus) {
		this.cropSoldStatus = cropSoldStatus;
	}
	public String getSoilPH() {
		return soilPH;
	}
	public void setSoilPH(String soilPH) {
		this.soilPH = soilPH;
	}
	
	

}
