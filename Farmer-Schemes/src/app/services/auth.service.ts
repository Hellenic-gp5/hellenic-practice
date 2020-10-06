import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
<<<<<<< HEAD
  registerUrl: string = 'http://localhost:8080/agrimensor/rest/addbidder';
=======
  registerUrl: string = 'http://localhost:8080/Agri-Rest/rest';
>>>>>>> 087e7be432d66810665e590495df4e5fc02fccf1

  constructor(private http: HttpClient) {}

  bidderRegister(bidderRegisterForm: FormGroup): Observable<any> {
    return this.http.post(this.registerUrl + '/addbidder', bidderRegisterForm);
  }

  farmerRegister(bidderRegisterForm: FormGroup): Observable<any> {
    return this.http.post(this.registerUrl + '/addfarmer', bidderRegisterForm);
  }
}
