import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../User.module';
import { UserApprovalService } from '../services/user-approval.service';
import { AuthService } from '../services/auth.service';
import {AdminService} from '../services/admin.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  list: User[] = [];
  //service: any;
  users: User[] = [];
  approved: String='Approved';
  rejected:String ='Rejected';
  userId:number;
  constructor(private service: AuthService, private serve: AdminService) {}

  ngOnInit() {
    this.service.getUserApprovalList().subscribe((data) => (this.users = data));
  }
  reject(userId) {
  this.serve.updateUserStatus(userId, 'Rejected')
  }
  accept(userId) {
    this.serve.updateUserStatus(userId, 'Approved') 
  }
}
