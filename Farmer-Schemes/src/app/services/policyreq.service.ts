import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClaimReq } from '../claimreq.module';

@Injectable({
  providedIn: 'root'
})
export class PolicyreqService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  constructor(private http: HttpClient) {}
  getClaimRequest()
  {
    return this.http.get<ClaimReq[]>(this.baseUrl+"/marketcrops");
  }
  updateClaimStatus(policyId:number, status:string)
{
  //please change the PathVariable to RequestParam in controller
  const params = new HttpParams()
      .append("status", status);
  return this.http
  .get(this.baseUrl + '/insurancestatus?polid=' + policyId, {params:params}).toPromise();
}
}
