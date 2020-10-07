import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Claim } from '../claim/claim.module';
import { InsuranceService } from '../services/insurance.service';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css'],
})
export class ClaimComponent implements OnInit {
  claim: Claim;
  stringifiedData: string;
  parsedJson: any;

  constructor(private service: InsuranceService) {}

  ngOnInit(): void {}

  saveClaim() {
    this.stringifiedData = JSON.stringify(this.claim);
    this.parsedJson = JSON.parse(this.stringifiedData);
    this.service.saveInsuranceClaim(this.parsedJson);
  }
}
