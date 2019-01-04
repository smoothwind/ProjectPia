import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NoAuthGuard } from './no-auth-guard.service';
import {AccountComponent} from './account.component';

const routes: Routes = [
  {
    path: 'login',
    component: AccountComponent,
    canActivate: [NoAuthGuard]
  },
  {
    path: 'register',
    component: AccountComponent,
    canActivate: [NoAuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule {}
