import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import * as global from './global';
import {PiaUser} from './model/pia-user';
import {EPiaErrCode} from './model/enums';


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
  // 用户登录
  logIn (username: String, password: String): EPiaErrCode {
    if (username.trim().length === 0 || password.trim().length === 0) {
      return EPiaErrCode.WRONG_PASSCODE_USERNAME;
    }
    // this.http.post<Map<String, PiaUser>>()(global.base_url + ':' + global.port + '/Account/signIn');
    // TODO: 知识点 post方法定义中 I typescript 允许制定多个类型，多个类型之间用| 分开。 方法可以接收或返回多种类型的指
      let response: number | PiaUser;
      this.http.post<PiaUser | number>(global.base_url + ':' + global.port + '/Account/signIn',
      JSON.stringify({'username': username, 'password': password}),
      {'headers': {'Content-Type': 'application/json'}}
      ).subscribe(data => response = data);

      /*
      if (response.) {

      }*/

    return EPiaErrCode.SUCCESS;
  }
}
