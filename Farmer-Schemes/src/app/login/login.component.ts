import { identifierModuleUrl } from '@angular/compiler';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginModel } from '../login.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login = new LoginModel
  test:number
  flag:boolean;
 roles :string[];

  constructor(private router:Router) {
    this.roles = ['Farmer', 'Bidder', "Admin"];
   }
  ngOnInit() {
  
  }
  loggedIn(){
    this.flag=true;
    this.test=1;
    if(this.login.role=="Admin")
    this.router.navigate(['admin']);
    else if(this.login.role=="Bidder")
    this.router.navigate(['bidder']);
    else
      this.router.navigate(['farmer']);
  }
  loggedOut(){
    this.flag=false;
  }
}
