import { identifierModuleUrl } from '@angular/compiler';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginModel } from '../login.module';
import { LoginService } from '../services/login.service';
import { User } from '../User.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: LoginModel;
  user: User;
  roles: string[];

  constructor(private router: Router, private service: LoginService) {
    this.login = new LoginModel();
    this.roles = ['Farmer', 'Bidder', 'Admin'];
  }
  ngOnInit() {
    localStorage.setItem('user', null);
  }
  async loggedIn() {
    await this.service.login(this.login).then((data) => (this.user = data));
    localStorage.setItem('user', JSON.stringify(this.user));
    localStorage.setItem('uname', this.user.name);
    localStorage.setItem('userIdd', this.user.userId.toString());
   // const userId = parseInt(userId.toString();)
    if (this.user) {
      this.service.setFlag(true);
    }
    if (this.user.role == 'Bidder') this.router.navigate(['bidder']);
    else if (this.user.role == 'Farmer') this.router.navigate(['farmer']);
    else this.router.navigate(['admin']);
  }
}
