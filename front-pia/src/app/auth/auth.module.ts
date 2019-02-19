import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { NoAuthGuard } from './no-auth-guard.service';
import { AuthRoutingModule } from './auth-routing.module';
import { AccountComponent } from './account.component';

@NgModule({
  declarations: [
    AccountComponent,
    AuthRoutingModule
  ],
  imports: [
    SharedModule,
    CommonModule
  ],
  providers: [
     NoAuthGuard
  ]
})
export class AuthModule { }
