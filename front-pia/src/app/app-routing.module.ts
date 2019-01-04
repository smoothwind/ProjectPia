import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountComponent } from './auth/account.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path: 'Account/:category', component: AccountComponent },
  {path: 'Home', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
