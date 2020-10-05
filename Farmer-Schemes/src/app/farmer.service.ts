import { Injectable } from '@angular/core';
import { from } from 'rxjs';
import { RegisterModel } from '../app/register.module';
import { FarmerRegisterModel } from '../app/FarmerRegister.module';

@Injectable({
  providedIn: 'root',
})
export class FarmerService {
  regList: RegisterModel[] = [];
  FarmerregList: FarmerRegisterModel[] = [];

  constructor() {}
  saveReg(reg: RegisterModel) {
    this.regList.push(reg);
  }
  saveFarmerReg(Farmerreg: FarmerRegisterModel) {
    this.FarmerregList.push(Farmerreg);
  }
}
