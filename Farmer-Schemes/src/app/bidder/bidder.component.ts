import { BidderService } from './../services/bidder.service';
import { from } from 'rxjs';
import { Bids } from './../bids.module';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bidder',
  templateUrl: './bidder.component.html',
  styleUrls: ['./bidder.component.css'],
})
export class BidderComponent implements OnInit {
  toggle: Boolean = false;
  bname:string;
  // Bidding History Array
   bids : Bids[] = [];

   constructor(private service : BidderService) {}

  //[
  //   {
  //     bidId: 1,
  //     cropType: 'Type1',
  //     cropName: 'Crop1',
  //     bidAmount: 50000,
  //     status: 'Accpeted',
  //   },
  //   {
  //     bidId: 2,
  //     cropType: 'Type2',
  //     cropName: 'Crop2',
  //     bidAmount: 60000,
  //     status: 'Waiting',
  //   },
  //   {
  //     bidId: 3,
  //     cropType: 'Type3',
  //     cropName: 'Crop3',
  //     bidAmount: 60000,
  //     status: 'Accpeted',
  //   },
  // ];

  // ngOnInit() {
  //   this.service.getBidHistory().subscribe((data) => (this.bids = data));
  // }
  ngOnInit(): void { this.bname = localStorage.getItem("uname");
  this.service.getBidHistory().subscribe((data) =>(this.bids = data));
}

  getBidHistory(){
    
  }

  applyBid() {
    this.toggle = !this.toggle;
  }
}
