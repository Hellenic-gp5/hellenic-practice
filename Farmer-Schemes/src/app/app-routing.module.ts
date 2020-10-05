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
import { DashboardComponent } from './dashboard/dashboard.component';
import { SellRComponent } from './SellR/sellR.component';
import { ClaimComponent } from './claim/claim.component';
import { ApplyComponent } from './apply/apply.component';
import { elementEventFullName } from '@angular/compiler/src/view_compiler/view_compiler';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
// <--------------Home Screen Routes-------------->
{ path: 'home', component: HomeComponent, //Home Screen Component
children:[{path:'login',redirectTo:'/login'},
{path:'register',redirectTo:'/signup'}] },

{ path: 'login', component: LoginComponent, //Login Screen Component
  children:[{path:'home',redirectTo:'/home'},
  {path:'register',redirectTo:'/signup'}
]},

{ path: 'signup', component: RegistrationComponent, //Registration Component
children:[{path:'home',redirectTo:'/home'},{path:'login',redirectTo:'/login'}] },

// <--------Bidder route----------->
  { path: 'bidder', component: BidderComponent },
 //<---------------Admin Module route-------------> 
  {path: 'admin', component: AdminWelcomeComponent, 
  children:[{path:'user',redirectTo:'/user',pathMatch:'full'},
  {path:'sell',redirectTo:'/sell',pathMatch:'full'},
  {path:'market',redirectTo:'/market',pathMatch:'full'},
  {path:'insurance', redirectTo:'/insurance',pathMatch:'full'}]},


  {path: 'user', component: UserComponent,
  children:[{path:'sell',redirectTo:'/sell',pathMatch:'full'},
  {path:'market',redirectTo:'/market',pathMatch:'full'},
  {path:'insurance', redirectTo:'/insurance',pathMatch:'full'},
  {path:'admin',redirectTo:'/admin',pathMatch:'full'}]},

  {path: 'sell', component: SellComponent,
  children:[{path:'user',redirectTo:'/user',pathMatch:'full'},
  {path:'market',redirectTo:'/market',pathMatch:'full'},
  {path:'insurance', redirectTo:'/insurance',pathMatch:'full'},
  {path:'admin',redirectTo:'/admin',pathMatch:'full'}]},


  {path: 'market', component: MarketComponent,
children:[ {path:'user',redirectTo:'/user',pathMatch:'full'},
{path:'sell',redirectTo:'/sell',pathMatch:'full'},
{path:'insurance', redirectTo:'/insurance',pathMatch:'full'},
{path:'admin',redirectTo:'/admin',pathMatch:'full'}]},

{path: 'insurance', component: InsuranceComponent,
children:[{path:'user',redirectTo:'/user',pathMatch:'full'},
{path:'sell',redirectTo:'/sell',pathMatch:'full'},
{path:'market',redirectTo:'/market',pathMatch:'full'},
{path:'admin',redirectTo:'/admin',pathMatch:'full'}]},


  
  
//  <-----------------These are farmer module routes------------> 
{path:'farmer',component:DashboardComponent, 
children:[ {path:'claim',redirectTo:'/claim',pathMatch:'full'},
{path:'apply',redirectTo:'/apply',pathMatch:'full'},
{path:'add',redirectTo:'/add',pathMatch:'full'}]  },


{path:'apply', component:ApplyComponent ,
children:[{path:'farmer', redirectTo:'/farmer',pathMatch:'full'},
 {path:'claim',redirectTo:'/claim',pathMatch:'full'},
 {path:'add',redirectTo:'/add',pathMatch:'full'}]},


{path:'add', component:SellRComponent, 
children:[{path:'farmer', redirectTo:'/farmer',pathMatch:'full'},
{path:'claim',redirectTo:'/claim',pathMatch:'full'},
{path:'apply',redirectTo:'/apply',pathMatch:'full'}]},


{path:'claim', component:ClaimComponent,
children:[{path:'farmer', redirectTo:'/farmer',pathMatch:'full'},
{path:'add',redirectTo:'/add',pathMatch:'full'},
{path:'apply',redirectTo:'/apply',pathMatch:'full'}]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
