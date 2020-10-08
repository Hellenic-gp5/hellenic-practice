import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Market } from '../marketplace.module';
@Injectable({
  providedIn: 'root'
})
export class MarketplaceService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  constructor(private http: HttpClient) {}
  getMarketCrops()
  {
    return this.http.get<Market[]>(this.baseUrl+"/marketcrops");
  }
}
