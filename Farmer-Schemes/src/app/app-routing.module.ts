import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { BidderComponent } from './bidder/bidder.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { MarketComponent } from './market/market.component';
import { UserComponent } from './user/user.component';
import { SellComponent } from './sell/sell.component';
import { InsuranceComponent } from './insurance/insurance.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, 
children:[{path:'login',redirectTo:'/login'},
{path:'register',redirectTo:'/signup'}] },

  { path: 'login', component: LoginComponent,
  children:[{path:'home',redirectTo:'/home'},
  {path:'register',redirectTo:'/signup'},
{path:'farmer',redirectTo:'/farmer-dashboard'},
{path:'bidder', redirectTo:'/bidder'},
{path:'admin',redirectTo:'/admin-welcome'}] },
  
  { path: 'signup', component: RegistrationComponent,
children:[{path:'home',redirectTo:'/home'},{path:'login',redirectTo:'/login'}] },

  { path: 'bidder', component: BidderComponent },
  
  {path: 'admin-welcome', component: AdminWelcomeComponent},
  {path: 'user', component: UserComponent},
  {path: 'sell', component: SellComponent},
  {path: 'market', component: MarketComponent},
  {path: 'insurance', component: InsuranceComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
