import { Component, OnInit } from '@angular/core';
import { User } from '../User.module';
import { UserApprovalService } from '../services/user-approval.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  list: User[] = [];
  //service: any;

  constructor(private service: UserApprovalService) {}

  ngOnInit() {
    //this.service.getUserApprovalList.subscribe((data) => (this.list = data));
  }
}
