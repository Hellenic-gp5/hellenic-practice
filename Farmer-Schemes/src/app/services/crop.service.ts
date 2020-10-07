import { HttpClient, HttpParams } from '@angular/common/http';
import { convertPropertyBinding } from '@angular/compiler/src/compiler_util/expression_converter';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Crop } from '../crop.module';
import { User } from '../User.module';

@Injectable({
  providedIn: 'root',
})
export class CropService {
  private baseUrl: string = 'http://localhost:8080/agrimensor/rest';
  crop: Crop;
  user: User;
  parsedJson: (
    text: string,
    reviver?: (this: any, key: string, value: any) => any
  ) => any;
  constructor(private router: Router, private http: HttpClient) {}
  saveFarmerCrop(crop: Crop): Promise<User> {
    const params = new HttpParams().append(
      'userId',
      this.user.userId.toString()
    );

    let result = this.http
      .post<User>(this.baseUrl + '/addCrop', [{ params: params }, crop])
      .toPromise();

    return result;
  }
}
