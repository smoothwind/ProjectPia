import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import {UserService} from './user.service';
import {ArtileService} from './artile.service';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    LoginComponent,
    AppComponent,
    ProfileComponent
  ],
  providers: [UserService, ArtileService, AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
