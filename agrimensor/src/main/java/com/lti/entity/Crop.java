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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name="Crop")
@SequenceGenerator(name="cropSeq", sequenceName = "crop_seq", initialValue = 1001, allocationSize = 1)

public class Crop {
	@Id
	@GeneratedValue(generator = "cropSeq",strategy = GenerationType.SEQUENCE)
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
	@Column
	private Date cropSoldDate;
	@Column
	private int cropQuantity;
	@Column(length = 10)
	private String cropSoldStatus;
	@Column
	private String soilPH;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="bidder_crop",
	joinColumns= {@JoinColumn(name="cropId")},
	inverseJoinColumns= {@JoinColumn(name="bidderId")})
	private Set<Bidder> bidder = new HashSet<Bidder>();
	
	//relation one-to-many for bid-crop
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Bid> bids = new ArrayList<Bid>();
	
	@ManyToOne
	private Farmer farmer;

	
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public Set<Bidder> getBidder() {
		return bidder;
	}
	public void setBidder(Set<Bidder> bidder) {
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
