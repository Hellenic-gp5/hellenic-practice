import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { Claim } from '../claim/claim.module';
import { InsuranceService } from '../services/insurance.service';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css'],
})
export class ClaimComponent implements OnInit {
  claim=new Claim();
  stringifiedData: string;
  parsedJson: any;

  constructor(private service: InsuranceService, private router:Router) {}

  ngOnInit(): void {}

  saveClaim(policyId) {
    this.stringifiedData = JSON.stringify(this.claim);
    this.parsedJson = JSON.parse(this.stringifiedData);
    this.service.saveInsuranceClaim(policyId, this.parsedJson);
    this.router.navigate(['farmer']);
  }
}
