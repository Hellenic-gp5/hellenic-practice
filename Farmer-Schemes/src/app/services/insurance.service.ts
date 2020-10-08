import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Claim } from '../claim/claim.module';

@Injectable({
  providedIn: 'root',
})
export class InsuranceService {
  private baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  // claim: Claim;

  constructor(private http: HttpClient) {}

  saveInsuranceClaim(policyId, claim: any) {
    return this.http
      .post(this.baseUrl + '/applyclaim?polid=' + policyId, claim)
      .subscribe((data) => (data = claim));}
    
  addInsurance(farmerId,ins:any){
    this.http.post(this.baseUrl + '/apply?fid=' + farmerId, ins).subscribe((data)=>(data=ins));


  }
 
    }

