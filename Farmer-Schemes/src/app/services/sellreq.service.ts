import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SellRequest } from '../sellrequest.module';
@Injectable({
  providedIn: 'root'
})
export class SellreqService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  constructor(private http: HttpClient) {}
  getSellRequest()
  {
    return this.http.get<SellRequest[]>(this.baseUrl+"/getAllCrops");
  }
  updateCropStatus(cropId:number, status:string)
{
  const params = new HttpParams()
      .append("cropSoldStatus", status);
  return this.http
  .get(this.baseUrl + '/updateCropStatus?cropId=' + cropId, {params:params}).toPromise();
}
}
