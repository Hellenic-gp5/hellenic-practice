import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Crop } from '../crop.module';
import { CropService } from '../services/crop.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sellR',
  templateUrl: './sellR.component.html',
  styleUrls: ['./sellR.component.css'],
})
export class SellRComponent implements OnInit {
  crop = new Crop();
  userId: string;
  constructor(private service: CropService, private router: Router) {}

  ngOnInit(): void {
    this.userId = localStorage.getItem("userId");
  }

  saveCrop() {
    this.service.saveFarmerCrop(this.crop);
    this.router.navigate(['list']);
  }
}
