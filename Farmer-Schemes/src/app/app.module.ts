import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BidderComponent } from './bidder/bidder.component';
import { RegistrationComponent } from './registration/registration.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { MarketComponent } from './market/market.component';
import { UserComponent } from './user/user.component';
import { SellComponent } from './sell/sell.component';
import { InsuranceComponent } from './insurance/insurance.component';
import {SellRComponent} from './SellR/sellR.component';
import {ApplyComponent} from './apply/apply.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {ClaimComponent} from './claim/claim.component';
import {NavbaryComponent} from './navbary/navbary.component';

@NgModule({
  declarations: [
    AppComponent,
    BidderComponent,
    RegistrationComponent,
    NavbarComponent,
    NavbaryComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    AdminWelcomeComponent,
    MarketComponent,
    UserComponent,
    SellComponent,
    InsuranceComponent,
    SellRComponent,
    DashboardComponent,
    ApplyComponent,
    ClaimComponent
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
