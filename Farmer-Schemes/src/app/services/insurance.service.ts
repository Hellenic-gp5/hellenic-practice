import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Claim } from '../claim/claim.module';

@Injectable({
  providedIn: 'root',
})
export class InsuranceService {
  private baseUrl: string = 'http://localhost:8081/agrimensor/rest';
  // claim: Claim;

  constructor(private http: HttpClient) {}

  saveInsuranceClaim(policyId, claim: any) {
    return this.http
      .post(this.baseUrl + '/-----?policyId=' + policyId, claim)
      .subscribe((data) => (data = claim));
  }
}
