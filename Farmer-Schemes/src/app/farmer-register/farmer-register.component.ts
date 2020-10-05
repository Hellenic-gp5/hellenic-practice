import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { FarmerRegisterModel } from '../FarmerRegister.module';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-farmer-register',
  templateUrl: './farmer-register.component.html',
  styleUrls: ['./farmer-register.component.css'],
})
export class FarmerRegisterComponent implements OnInit {
  farmerReg = new FarmerRegisterModel();
  constructor(private service: FarmerService) {
    this.farmerReg = new FarmerRegisterModel();
  }

  ngOnInit(): void {}
  selectedCountry: String = '--Choose State--';
  States: Array<any> = [
    {
      name: 'Maharashtra',
      cities: ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn'],
    },
    { name: 'Uttar Pradesh', cities: ['Barcelona'] },
    { name: 'Kerala', cities: ['Downers Grove'] },
    { name: 'Rajasthan', cities: ['Puebla'] },
    { name: 'Karnataka', cities: ['Delhi', 'Kolkata', 'Mumbai', 'Bangalore'] },
  ];

  cities: Array<any>;

  //cities: Array<any>;

  changeState(state) {
    this.cities = this.States.find((cntry) => cntry.name == state).cities;
  }

  //changeState(state) {
  //this.cities = this.Countries.find(cntry => cntry.name == this.selectedCountry).states.find(stat => stat.name == state).cities;
  //}

  saveFarmerReg() {
    this.service.saveFarmerReg(this.farmerReg);
  }
}
