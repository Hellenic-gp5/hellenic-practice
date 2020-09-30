package com.lti.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.repo.BidRepo;
import com.lti.repo.BidderRepo;


@Service
public class BidderServiceImp implements BidderService {
	
	@Autowired
	private BidderRepo repo;


	@Transactional(value = TxType.REQUIRED)
	public void persist(Bidder bidder) {
		repo.saveBidder(bidder);

	}

	public Bidder find(int bidderId) {
		return repo.fetchBidderById(bidderId);
	}

	public List<Bidder> load() {
		return repo.listBidder();
	}

	@Transactional(value = TxType.REQUIRED)
	public void remove(int bidderId) {
		repo.deleteBidder(bidderId);

	}
	@Transactional(value = TxType.REQUIRED)
	public void edit(Bidder bidder) {
		repo.updateBidder(bidder);

	}

}
