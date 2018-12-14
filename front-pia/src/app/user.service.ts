import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as global from './global';
import { PiaUser } from './model/pia-user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // 管理登录用户
  loginedUser: Map<number, PiaUser> = new Map<number, PiaUser> ();
  currentActivedUserId = -1;

  constructor(private http: HttpClient) {

  }

  getUserByID(id: Number) {
    return this.http.get<PiaUser>( global.base_url + ':' + global.port + '/Account/user/' + id);
  }

  getUserByName(name: String) {
    return this.http.get<PiaUser>(global.base_url + ':' + global.port + '/Account/username/' + name);
  }

  // 设置当前登录用户
  setCurrentUser(user: PiaUser ) {
    this.currentActivedUserId = user.idUser;
    if (!this.loginedUser.has(user.idUser)) {

      this.loginedUser.set(user.idUser, user);
    }
  }
  // 当前用户登出
  logOut(idUser: number) {
    if (this.currentActivedUserId === idUser && this.loginedUser.has(idUser)) {
      this.loginedUser.delete(idUser);
    }
    this.currentActivedUserId = -1;
  }
  // 切换账户
  SwitchAccount(idUser: number) {
    if (this.currentActivedUserId === idUser && this.loginedUser.has(idUser)) {
      this.currentActivedUserId = idUser;
    }
  }
  // TODO: 登录

}
