import { i18nMetaToDocStmt } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { policy } from '../dashboard/insurance.model';
import { InsuranceService } from '../services/insurance.service';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.css'],
})
export class ApplyComponent implements OnInit {
 insurance=new policy();

 flag:boolean=false;
  stringifiedData: string;
  parsedJson: any;
constructor(private service:InsuranceService, private router:Router){}
 onCalculate(){
   this.flag=true;
this.insurance.policyCompany="Agrimensor Finances";
this.insurance.policyPremiumAmount= 0.10*this.insurance.sumInsured;
if(this.insurance.season=="Rabi")
  this.insurance.policySharedPremium= 0.015*this.insurance.policyPremiumAmount;
else
  this.insurance.policySharedPremium= 0.020 *this.insurance.policyPremiumAmount;

  this.insurance.sumPerHectare= this.insurance.sumInsured/this.insurance.policyCropArea;

  this.insurance.policyStatus="Active";

 }
farmerId: number;
 onApply()
 {
  this.stringifiedData = JSON.stringify(this.insurance);
  this.parsedJson = JSON.parse(this.stringifiedData);
  this.service.addInsurance(this.farmerId,this.parsedJson);
  this.router.navigate(['farmer']); }
 
  ngOnInit(): void {
    this.farmerId=parseInt(localStorage.getItem("userId"));
  }
  
}
