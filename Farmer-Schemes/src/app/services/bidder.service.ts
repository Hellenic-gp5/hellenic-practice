import { Bids } from './../bids.module';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../User.module';

@Injectable({
  providedIn: 'root'
})
export class BidderService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  bidderId : number;
  cropId : number;
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

  applyBid()
  {
    return this.http.get(this.baseUrl + '/makebid?bidderid='+ this.bidderId + '&cropid=' + this.cropId);
  }
}
