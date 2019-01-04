import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './core/services/user.service';
import { ArtileService } from './core/services/artile.service';
import { AccountComponent } from './auth/account.component';
import { UserStateService } from './core/services/userstate.service';

@NgModule({
  declarations: [ // 本模块定义的组件、指令、管道，模块内部使用的类
    AppComponent,
    AccountComponent,
  ],
  imports: [  // Angular 提供的模块
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [UserService, ArtileService, UserStateService], // 服务
  bootstrap: [AppComponent]
})
export class AppModule { }
