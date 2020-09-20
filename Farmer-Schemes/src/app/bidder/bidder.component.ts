import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bidder',
  templateUrl: './bidder.component.html',
  styleUrls: ['./bidder.component.css'],
})
export class BidderComponent implements OnInit {
  toggle: Boolean = false;
  // Bidding History Array
  bids = [
    {
      bidId: 1,
      cropType: 'Type1',
      cropName: 'Crop1',
      bidAmount: 50000,
      status: 'Accpeted',
    },
    {
      bidId: 2,
      cropType: 'Type2',
      cropName: 'Crop2',
      bidAmount: 60000,
      status: 'Waiting',
    },
    {
      bidId: 3,
      cropType: 'Type3',
      cropName: 'Crop3',
      bidAmount: 60000,
      status: 'Accpeted',
    },
  ];

  constructor() {}

  ngOnInit(): void {}
  applyBid() {
    this.toggle = !this.toggle;
  }
}
