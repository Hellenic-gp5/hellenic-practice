import { Component, OnInit } from '@angular/core';
import { SellRequest } from '../sellrequest.module';
import { SellreqService } from '../services/sellreq.service';
@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
sellreq : SellRequest[]=[];
cropId:number;
  constructor(private service : SellreqService) { }

  ngOnInit() {
    this.service.getSellRequest().subscribe((data) => (this.sellreq = data));
  }
  rejected(cropId) {
    this.service.updateCropStatus(cropId, 'Rejected')
    }
    unsold(cropId) {
      this.service.updateCropStatus(cropId, 'Claimed') 
    }

}
