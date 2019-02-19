import {Time} from '@angular/common';

export class PiaUser {
  private _idUser: number;
  private _userName: String;
  private _password: String;
  private _gender: number;
  private _eMail: String;
  private _address: String;
  private _bio: String;
  private _updateTime: Time;
  constructor ( idUser?: number,
                userName?: string,
                password?: string,
                gender?: number,
                eMail?: string,
                address?: string,
                bio?: string,
                updateTime?: Time) {
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

  get idUser() {
    return this._idUser;
  }

  set idUser(value) {
    this._idUser = value;
  }

  get userName() {
    return this._userName;
  }

  set userName(value) {
    this._userName = value;
  }

  get password() {
    return this._password;
  }

  set password(value) {
    this._password = value;
  }

  get gender() {
    return this._gender;
  }

  set gender(value) {
    this._gender = value;
  }

  get eMail() {
    return this._eMail;
  }

  set eMail(value) {
    this._eMail = value;
  }

  get address() {
    return this._address;
  }

  set address(value) {
    this._address = value;
  }

  get bio() {
    return this._bio;
  }

  set bio(value) {
    this._bio = value;
  }

  get updateTime() {
    return this._updateTime;
  }

  set updateTime(value) {
    this._updateTime = value;
  }

  toString(): String {
    return this.userName;
  }
}
