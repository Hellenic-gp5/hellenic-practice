import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  registerUrl: string = 'http://localhost:8080/agrimensor/rest/addbidder';

  constructor(private http: HttpClient) {}

  bidderRegister(bidderRegisterForm: FormGroup): Observable<any> {
    return this.http.post(this.registerUrl, bidderRegisterForm);
  }
}
