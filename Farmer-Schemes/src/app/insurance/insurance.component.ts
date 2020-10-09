import { Component, OnInit } from '@angular/core';
import { ClaimReq } from '../claimreq.module';
import { PolicyreqService } from '../services/policyreq.service';
@Component({
  selector: 'app-insurance',
  templateUrl: './insurance.component.html',
  styleUrls: ['./insurance.component.css']
})
export class InsuranceComponent implements OnInit {
  claims:ClaimReq[]=[];
  constructor(private service : PolicyreqService) { }

  ngOnInit() {this.service.getClaimRequest().subscribe((data) => (this.claims= data));
  }
  //check for params
  claimApproved(policyId) {
    this.service.updateClaimStatus(policyId, 'Claim Approved')
    }
    claimRejected(policyId) {
      this.service.updateClaimStatus(policyId, 'Claim Rejetced') 
    }


}
