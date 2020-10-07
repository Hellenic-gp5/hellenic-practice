import { Component, OnInit } from '@angular/core';
import { crop } from './crop.model';
import { items } from './bid.model';
import { previous } from './pb.model';
import { policy } from './insurance.model';
import { FarmerDashboardService } from '../services/farmer-dashboard.service';
import { from } from 'rxjs';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  fname: string;
  crops: crop[] = [];
  bids: items[] = [];
  pb: boolean = false;
  bid: string = 'View Details';
  pbids: previous[] = [];
  cropBid: items;
  pri: previous;
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
    await this.service
      .viewMarketPlaceDetails(this.pri)
      .then((data) => (this.cropBid = data));
    localStorage.setItem('cropBid', JSON.stringify(this.cropBid));
    localStorage.setItem('id', this.cropBid.cropId.toString());
  }
  ngOnInit(): void {
    this.fname = localStorage.getItem('uname');
    this.service.viewMarketPlace().subscribe((data) => (this.bids = data));
    this.service.viewSoldCropList().subscribe((data) => (this.crops = data));
  }
}
