import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../User.module';
import { UserApprovalService } from '../services/user-approval.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  list: User[] = [];
  //service: any;
  users: User[] = [];
  constructor(private service: AuthService) {}

  ngOnInit() {
    this.service.getUserApprovalList().subscribe((data) => (this.users = data));
  }
  reject() {
    //   const params = new HttpParams()
    //     .append("status", "Rejected");
    //   this.service.
  }
  accept() {}
}
