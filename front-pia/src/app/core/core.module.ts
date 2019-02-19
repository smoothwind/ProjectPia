import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import {HttpTokenInterceptor} from './interceptors';
import { CommonModule } from '@angular/common';
import {
  ApiService,
  ArtileService,
  JwtService,
  UserService,
  UserStateService,
  ProfilesService
} from './services';
@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpTokenInterceptor, multi: true },
    ApiService,
    ArtileService,
    JwtService,
    UserService,
    UserStateService,
    ProfilesService
  ],
})
export class CoreModule { }
