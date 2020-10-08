import { Component, OnInit } from '@angular/core';
import { Market } from '../marketplace.module';
import { MarketplaceService } from '../services/marketplace.service';
import { SellRequest } from '../sellrequest.module';
import { SellreqService } from '../services/sellreq.service';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {
  market : Market[]=[];
  cropId:number;
    constructor(private service : MarketplaceService, private serve :SellreqService ) { }
  
    ngOnInit() {
      this.service.getMarketCrops().subscribe((data) => (this.market = data));
    }
    rejectbid(cropId) {
      this.serve.updateCropStatus(cropId, 'Rejected')
      }
      sold(cropId) {
        this.serve.updateCropStatus(cropId, 'Sold') 
      }
  

}
