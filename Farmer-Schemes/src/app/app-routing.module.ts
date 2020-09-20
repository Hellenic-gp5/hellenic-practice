import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BidderComponent } from './bidder/bidder.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  { path: 'bidder', component: BidderComponent },
  { path: 'signup', component: RegistrationComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
