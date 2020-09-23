import { Component, OnInit } from '@angular/core';
import { RegisterModel } from '../register.module';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  reg = new RegisterModel();
  constructor(private service: FarmerService) {
    this.reg = new RegisterModel();
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

  saveReg() {
    this.service.saveReg(this.reg);
  }
}
