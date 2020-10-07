import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseUrl: string = 'http://localhost:8081/agrimensor/rest';

  constructor(private http: HttpClient) { }
}
