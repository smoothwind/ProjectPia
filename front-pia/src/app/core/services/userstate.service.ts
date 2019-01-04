import { Injectable } from '@angular/core';

export enum STATE {
  LOGIN, LOGOUT,
}

@Injectable({
  providedIn: 'root'
})

export class UserStateService {
  constructor(public state: STATE, public id?: number) { }
}

// export const SHARED_STATE = new OpaqueToken("shared_state");
