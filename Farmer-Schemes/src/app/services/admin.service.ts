import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseUrl: string = 'http://localhost:8081/agrimensor/rest';

  constructor(private http: HttpClient) { }
updateUserStatus(userId:number, status:string)
{
  const params = new HttpParams()
      .append("userStatus", status);
  return this.http
  .get(this.baseUrl + '/userstatus?userId=' + userId, {params:params}).toPromise();
}
}