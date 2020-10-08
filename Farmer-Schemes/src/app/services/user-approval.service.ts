import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../User.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserApprovalService {
  user: User;

  baseUrl: string = 'http://localhost:8081/agrimensor/rest';

  constructor(private http: HttpClient) {}

  //getUserApprovalList(user: User): Observable<any>
  //{
  // return this.http.post(this.baseUrl +"/list", user);
  // }
}
