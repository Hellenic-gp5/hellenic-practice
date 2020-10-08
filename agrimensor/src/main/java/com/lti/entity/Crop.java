package com.lti.entity;

import java.util.ArrayList;

import java.util.Date;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Crop")
@SequenceGenerator(name="cropsSeq", sequenceName = "crops_seq2", initialValue = 101, allocationSize = 1)

public class Crop {
	@Id
	@GeneratedValue(generator = "cropsSeq",strategy = GenerationType.SEQUENCE)
	@Column(name="cropId")
	private int cropId;
	@Column(length=30)
	private String cropName;
	@Column(length=30)
	private String cropType;
	@Column(length=30)
	private String fertilizer;
	@Column
	private double cropBasePrice;
	@Column
	private double cropSoldPrice;
	@Column(length=14)
	private String cropSoldDate;
	@Column
	private Number currentBid;
	@Column
	private int cropQuantity;
	@Column(length = 80)
	private String cropSoldStatus= "Waiting for approval";
	@Column(length=50)
	private String soilPH;
	/**
	 * @author Sakshi
	 *Many to many relation with bidder
	 */
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="bidder_crop",
	joinColumns= {@JoinColumn(name="cropId")},
	inverseJoinColumns= {@JoinColumn(name="bidderid")})
	@JsonIgnore
	private List<Bidder> bidder = new ArrayList<Bidder>();
	
	
	//relation one-to-many for bid-crop entites
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Bid> bids = new ArrayList<Bid>();
	
//	@ManyToOne
//	@JsonIgnore
//	private Farmer farmer;
	
	
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
//	public Farmer getFarmer() {
//		return farmer;
//	}
//	public void setFarmer(Farmer farmer) {
//		this.farmer = farmer;
//	}
	public List<Bidder> getBidder() {
		return bidder;
	}
	public void setBidder(List<Bidder> bidder) {
		this.bidder = bidder;
	}
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
	public String getCropSoldDate() {
		return cropSoldDate;
	}
	public void setCropSoldDate(String cropSoldDate) {
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
	public Number getCurrentBid() {
		return currentBid;
	}
	public void setCurrentBid(Number currentBid) {
		this.currentBid = currentBid;
	}
	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropName=" + cropName + ", cropType=" + cropType + ", fertilizer="
				+ fertilizer + ", cropBasePrice=" + cropBasePrice + ", cropSoldPrice=" + cropSoldPrice
				+ ", cropSoldDate=" + cropSoldDate + ", currentBid=" + currentBid + ", cropQuantity=" + cropQuantity
				+ ", cropSoldStatus=" + cropSoldStatus + ", soilPH=" + soilPH + ", bidder=" + bidder + ", bids=" + bids
				+ "]";
	}
	
	
	

}
