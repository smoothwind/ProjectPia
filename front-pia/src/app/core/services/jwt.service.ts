import { Injectable } from '@angular/core';


@Injectable(
  { providedIn: 'root' } // todo： 研究一下providedIn的含义及作用
)
export class JwtService {

  getToken(): String {
    return window.localStorage['jwtToken'];
  }

  saveToken(token: String) {
    window.localStorage['jwtToken'] = token;
  }

  destroyToken() {
    window.localStorage.removeItem('jwtToken');
  }

}
