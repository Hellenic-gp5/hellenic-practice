package com.lti.repo;

public class Counts {

	public Number allUsers;
	public Number allFarmers;
	public Number allBidders;
	public Number allClaims;
	public Number approvedClaims;
	public Number rejectedClaims;
	public Number allSellReq;
	public Number rejectedSellReq;
	public Number soldCrops;

	public Number getAllBidders() {
		return allBidders;
	}

	public void setAllBidders(Number allBidders) {
		this.allBidders = allBidders;
	}

	public Number getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(Number allUsers) {
		this.allUsers = allUsers;
	}

	public Number getAllFarmers() {
		return allFarmers;
	}

	public void setAllFarmers(Number allFarmers) {
		this.allFarmers = allFarmers;
	}

	public Number getAllClaims() {
		return allClaims;
	}

	public void setAllClaims(Number allClaims) {
		this.allClaims = allClaims;
	}

	public Number getApprovedClaims() {
		return approvedClaims;
	}

	public void setApprovedClaims(Number approvedClaims) {
		this.approvedClaims = approvedClaims;
	}

	public Number getRejectedClaims() {
		return rejectedClaims;
	}

	public void setRejectedClaims(Number rejectedClaims) {
		this.rejectedClaims = rejectedClaims;
	}

	public Number getAllSellReq() {
		return allSellReq;
	}

	public void setAllSellReq(Number allSellReq) {
		this.allSellReq = allSellReq;
	}

	public Number getRejectedSellReq() {
		return rejectedSellReq;
	}

	public void setRejectedSellReq(Number rejectedSellReq) {
		this.rejectedSellReq = rejectedSellReq;
	}

	public Number getSoldCrops() {
		return soldCrops;
	}

	public void setSoldCrops(Number soldCrops) {
		this.soldCrops = soldCrops;
	}/*
		 * public Number getCurrentBid() { return currentBid; } public void
		 * setCurrentBid(Number currentBid) { this.currentBid = currentBid; } public
		 * Number getTotalBids() { return totalBids; } public void setTotalBids(Number
		 * totalBids) { this.totalBids = totalBids; } public Number getActiveBids() {
		 * return activeBids; } public void setActiveBids(Number activeBids) {
		 * this.activeBids = activeBids; }
		 */
}
