import { Component, OnInit } from '@angular/core';
import {crop} from './crop.model';
import {items} from './bid.model';
import {previous} from './pb.model';
import {policy} from './insurance.model';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  crops:crop[]=[];
  bids:items[]=[];
  pb:boolean=false;
  bid:string="View Details";
  pbids:previous[]=[];
  policies:policy[]=[];
  constructor() { }
  previousBid(){
    if(this.bid=="View Details")
    {this.pb=true;
      this.bid="close";}
    else
    {this.pb=false;
    this.bid="View Details";}  
    
  }
  ngOnInit(): void {
  }

}
