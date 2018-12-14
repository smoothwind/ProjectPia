import {Time} from '@angular/common';

export class PiaUser {

  constructor (public idUser?: number,
               public userName?: string,
               public password?: string,
               public gender?: number,
               public eMail?: string,
               public address?: string,
               public bio?: string,
               public updateTime?: Time) {
  }

  /*
  toString(): String {
    return JSON.stringify({
      'username': this._userName,
      'password': this._password,
      'gender': this._gender,
      'email': this._eMail,
      'address': this._address,
      'bio': this._bio,
      'updateTime': this._updateTime
    });
  }*/

}
