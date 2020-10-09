import { hell } from './makeBid.model';
import { items } from './../dashboard/bid.model';
import { Crop } from './../crop.module';
import { FarmerDashboardService } from './../services/farmer-dashboard.service';
import { BidderService } from './../services/bidder.service';
import { from } from 'rxjs';
import { Bids } from './../bids.module';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bidder',
  templateUrl: './bidder.component.html',
  styleUrls: ['./bidder.component.css'],
})
export class BidderComponent implements OnInit {
  toggle: Boolean = false;
  bname: string;
  // Bidding History Array
  bids: Bids[] = [];
  crops: items[] = [];
  cropId: number;
  bid= new hell();
  stringifiedData: string;
  parsedJson: any;

  constructor(
    private service: BidderService,
    private service2: FarmerDashboardService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.bname = localStorage.getItem('uname');
    this.service.getBidHistory().subscribe((data) => (this.bids = data));
    this.service2.viewMarketPlace().subscribe((data) => (this.crops = data));
  }

  async applyBid(u: number) {
    this.cropId = u;
    this.toggle = !this.toggle;
  }

  async makeBid() {
    this.stringifiedData = JSON.stringify(this.bid);
    this.parsedJson = JSON.parse(this.stringifiedData);
    await this.service.addBid(this.parsedJson,this.cropId);
    this.router.navigate(['/bidder']);
  }
}
