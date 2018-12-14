import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './user.service';
import { ArtileService } from './artile.service';
import { AccountComponent } from './account/account.component';

@NgModule({
  declarations: [ // 本模块定义的组件、指令、管道，模块内部使用的类
    AppComponent,
    AccountComponent,
    ProfileComponent
  ],
  imports: [  // Angular 提供的模块
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [UserService, ArtileService], // 服务
  bootstrap: [AppComponent]
})
export class AppModule { }
