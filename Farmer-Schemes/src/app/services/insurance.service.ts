import { Injectable } from '@angular/core';
import { Claim } from '../claim/claim.module';

@Injectable({
  providedIn: 'root',
})
export class InsuranceService {
  claim: Claim;

  constructor() {}

  saveInsuranceClaim(claim: any) {}
}
