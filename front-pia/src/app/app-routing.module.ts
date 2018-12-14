import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { AccountComponent } from './account/account.component';
import {AppComponent} from './app.component';

const routes: Routes = [
  {path: 'Account/:category', component: AccountComponent },
  {path: 'Profile', component: ProfileComponent, },
  {path: 'Home', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
