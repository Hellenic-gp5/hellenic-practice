import { Component, OnInit } from '@angular/core';
import { crop1 } from './crop1.model';
import { items } from './bid.model';
import { previous } from './pb.model';
import { policy } from './insurance.model';
import { FarmerDashboardService } from '../services/farmer-dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  test: number;
  fname: string;
  crops: crop1[] = [];
  bids: items[] = [];
  pb: boolean = false;
  bid: string = 'View Details';
  pbids: previous[] = [];
  cropBid: items;
  policies: policy[] = [];
  
  constructor(private service: FarmerDashboardService) {}
  async previousBid() {
    if (this.bid == 'View Details') {
      this.pb = true;
      this.bid = 'close';
    } else {
      this.pb = false;
      this.bid = 'View Details';
    }
  

    /* await this.service
      .viewMarketPlaceDetails(this.pri)
      .then((data) => (this.cropBid = data));
    localStorage.setItem('cropBid', JSON.stringify(this.cropBid));
    localStorage.setItem('id', this.cropBid.cropId.toString());*/
  }
  previousBidsOnCrop(cropId: number) {
    if (this.bid == 'View Details') {
      this.service
        .viewMarketPlaceDetails(cropId)
        .subscribe((data) => (this.pbids = data));
      this.pb = true;
      this.bid = 'close';
      this.test = cropId;
    } else {
      this.pbids.length = 0;
      this.pb = false;
      this.bid = 'View Details';
      this.test = null;
    }
  }

  ngOnInit(): void {
    this.fname = localStorage.getItem('uname');
    this.service.viewMarketPlace().subscribe((data) => (this.bids = data));
    this.service.viewSoldCropList().subscribe((data) => (this.crops = data));
  }
}
