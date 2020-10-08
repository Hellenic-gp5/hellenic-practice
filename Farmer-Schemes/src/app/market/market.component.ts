import { Component, OnInit } from '@angular/core';
import { Market } from '../marketplace.module';
import { MarketplaceService } from '../services/marketplace.service';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {
  market : Market[]=[];
    constructor(private service : MarketplaceService) { }
  
    ngOnInit() {
      this.service.getMarketCrops().subscribe((data) => (this.market = data));
    }
  

}
