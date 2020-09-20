import { Component, OnInit } from '@angular/core';
import { LoginModel } from '../login.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login = new LoginModel
  flag:boolean;
 roles :string[];

  constructor() {
    this.roles = ['Farmer', 'Bidder', "Admin"];
   }
  ngOnInit() {
  
  }
  loggedIn(){
    this.flag=true;
  }
  loggedOut(){
    this.flag=false;
  }
}
