import { Injectable } from '@angular/core';
import { RegisterModel } from '../app/register.module';

@Injectable({
  providedIn: 'root',
})
export class FarmerService {
  regList: RegisterModel[] = [];

  constructor() {}
  saveReg(reg: RegisterModel) {
    this.regList.push(reg);
  }
}
