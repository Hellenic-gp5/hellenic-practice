import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '.././user.module';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  baseUrl: string = 'http://localhost:8080/agrimensor/rest';

  constructor(private http: HttpClient) {}

  bidderRegister(bidderRegisterForm: FormGroup): Observable<any> {
    return this.http.post(this.baseUrl + '/addbidder', bidderRegisterForm);
  }

  farmerRegister(farmerRegisterForm: FormGroup): Observable<any> {
    return this.http.post(this.baseUrl + '/addfarmer', farmerRegisterForm);
  }

  getUserApprovalList() {
    return this.http.get<User[]>(this.baseUrl + '/approvallist');
  }

  sendEmail(emailId) {
    return this.http.get<User[]>(this.baseUrl + '/sendMail?emailId=' + emailId);
  }
}
