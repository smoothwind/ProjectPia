import { Injectable } from '@angular/core';
import { NodeLogger } from '@angular/core/src/view';
import { HttpClient } from '@angular/common/http';
import * as global from './global';
import { PiaUser } from './model/pia-user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private logger: NodeLogger, private http: HttpClient) {

  }

  getUserByID(id: Number) {
    return this.http.get<PiaUser>( global.base_url + ':' + global.port + '/Accout/user/' + id);
  }
}
