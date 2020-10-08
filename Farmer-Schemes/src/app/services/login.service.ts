import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginModel } from '.././login.module';
import { User } from '.././User.module';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  userLogin: boolean = false;
  flag: boolean;
  private baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  constructor(private router: Router, private http: HttpClient) {
    this.flag = false;
  }

  login(login: LoginModel): Promise<User> {
    const params = new HttpParams()
      .append('username', login.username)
      .append('password', login.password)
      .append('role', login.role);

    let result = this.http
      .get<User>(this.baseUrl + '/login', { params: params })
      .toPromise();
    return result;
  }
  setFlag(b: boolean) {
    this.flag = b;
  }
  getFlag(): boolean {
    return this.flag;
  }
}
