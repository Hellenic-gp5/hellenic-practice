import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Bids } from '../bids.module';
import { items } from '../dashboard/bid.model';
import { crop } from '../dashboard/crop.model';
import { previous } from '../dashboard/pb.model';

@Injectable({
  providedIn: 'root',
})
export class FarmerDashboardService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  farmerId: number;
  bids: items;
  cropId: number;

  constructor(private router: Router, private http: HttpClient) {
    this.farmerId = parseInt(localStorage.getItem('userId'));
    this.cropId = parseInt(localStorage.getItem('id'));
  }

  viewSoldCropList() {
    return this.http.get<crop[]>(this.baseUrl + '/');
  }

  viewMarketPlace() {
    return this.http.get<items[]>(this.baseUrl + '/marketcrops');
  }

  viewMarketPlaceDetails(pri: previous): Promise<items> {
    const params = new HttpParams().append(
      'cropId',
      this.bids.cropId.toString()
    );

    let result = this.http
      .get<items>(this.baseUrl + '/getBidsOnCrops', { params: params })
      .toPromise();
    return result;

    //   return this.http.get<previous[]>(this.baseUrl + '/getBidsOnCrops'   );
  }
}
