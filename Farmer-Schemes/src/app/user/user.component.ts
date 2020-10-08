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
  async reject(userId) {
    var ans = confirm("This user will be rejected. Click Ok to proceed. ");
    if (ans) {
      await this.serve.updateUserStatus(userId, 'Rejected')
    }
  
  }
 async accept(userId) {
    var ans = confirm("This user will be Approved. Click Ok to proceed. ");
    if (ans) {
     this.serve.updateUserStatus(userId, 'Approved') 
  }
}
}
