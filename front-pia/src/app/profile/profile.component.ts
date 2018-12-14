import { Component, OnInit } from '@angular/core';
import {PiaUser} from '../model/pia-user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: PiaUser;
  constructor(user?: PiaUser ) { }
  ngOnInit() {
  }

  isBelonged() {
    return true;
  }
}
