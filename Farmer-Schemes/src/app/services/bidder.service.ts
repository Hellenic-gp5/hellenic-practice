import { Bids } from './../bids.module';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../User.module';
import { hell } from '../bidder/makeBid.model';

@Injectable({
  providedIn: 'root'
})
export class BidderService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  bidderId : number;
  cropId : number;
  bid:any;
  user: User;
  parsedJson: (
    text: string,
    reviver?: (this: any, key: string, value: any) => any
  ) => any; 

  constructor(private http: HttpClient) {
    this.bidderId = parseInt(localStorage.getItem("userId")); 
  }

  getBidHistory()
  {
    return this.http.get<Bids[]>(this.baseUrl +'/listbids?bidderid=' + this.bidderId);
  }

  addBid(Id: number)
  {
    // this.cropId = Id;
  this.http.post(this.baseUrl + '/makebid?bidderid='+ this.bidderId + '&cropid=' + Id, this.bid);
  }

  setBid(b:any){this.bid=b;}
}
