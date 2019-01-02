import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as global from './global';
import {PiaUser} from './model/pia-user';
import {EPiaErrCode} from './model/enums';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  // 管理登录用户
  loginedUser: Map<number, PiaUser> = new Map<number, PiaUser>();
  currentActivedUserId = -1;

  constructor(private http: HttpClient) {

  }

  getUserByID(id: Number) {
    return this.http.get<PiaUser>(global.base_url + ':' + global.port + '/Account/user/' + id);
  }

  getUserByName(name: String) {
    return this.http.get<PiaUser>(global.base_url + ':' + global.port + '/Account/username/' + name);
  }

  // 获取当前登录用户
  getCurrentUser(): PiaUser {
    return this.loginedUser.get(this.currentActivedUserId);
  }
  // 设置当前登录用户
  setCurrentUser(user: PiaUser) {
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

  signUp(user : PiaUser): EPiaErrCode {
    let nuser: PiaUser;
    let code: String;
    if (this.getUserByName(user.userName) === null) {
      (this.http.post<PiaUser>(global.base_url + ':' + global.port + '/Account/signUp/',JSON.stringify({'idUser:':'','userName':user.userName,
        'password':user.password, 'eMail':user.eMail,
        'gender':user.gender,
        'address':user.address,
        'bio': user.bio
      }),{ 'headers': { 'Content-Type': 'application/json' }})).subscribe(
        data => {
          code = data['retCode'];

          console.log('retCode: ' + code);

          if (code === 'success') {
            // 设置对象属性
            nuser = new PiaUser();
            nuser.idUser = data['user'].idUser;
            nuser.userName = data['user'].userName;
            nuser.password = data['user'].password;
            nuser.gender = data['user'].gender;
            nuser.eMail = data['user'].eMail;
            nuser.address = data['user'].address;
            nuser.bio = data['user'].bio;
            nuser.updateTime = data['user'].updateTime;
            this.setCurrentUser(nuser);
          } else {
            return EPiaErrCode.FAILED;
          }
        }
      );
      return EPiaErrCode.SUCCESS;
    }
    return EPiaErrCode.FAILED;
  }

  // 用户登录
  logIn(username: String, password: String): EPiaErrCode {
    console.log('UserServices: 登录中。。。');
    if (username.trim().length === 0 || password.trim().length === 0) {
      return EPiaErrCode.WRONG_PASSCODE_USERNAME;
    }
    // this.http.post<Map<String, PiaUser>>()(global.base_url + ':' + global.port + '/Account/signIn');
    // TODO: 知识点 post方法定义中 I typescript 允许制定多个类型，多个类型之间用| 分开。 方法可以接收或返回多种类型的
    let user: PiaUser;
    let code: String;
    (this.http.post<Map<String, Object>>(global.base_url + ':' + global.port + '/Account/signIn',
      JSON.stringify({ 'username': username, 'password': password }),
      { 'headers': { 'Content-Type': 'application/json' } })).subscribe(data => {
        code = data['retCode'];

        console.log('retCode: ' + code);

        if (code === 'success') {
          // 设置对象属性
          user = new PiaUser();
          user.idUser = data['user'].idUser;
          user.userName = data['user'].userName;
          user.password = data['user'].password;
          user.gender = data['user'].gender;
          user.eMail = data['user'].eMail;
          user.address = data['user'].address;
          user.bio = data['user'].bio;
          user.updateTime = data['user'].updateTime;
          this.setCurrentUser(user);
        } else {
          return EPiaErrCode.FAILED;
        }
      });

    console.log('UserServices: 登录调用API结束。。。');
    return EPiaErrCode.SUCCESS;
  }
}
