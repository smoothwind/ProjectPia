import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Errors, PiaUser} from '../core/models';
import {FormGroup} from '@angular/forms';
import {UserService} from '../core/services';



@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent {
  isSubmitting = false;
  errors: Errors = {errors: {}};
  authType: String = '';
  authForm: FormGroup;


  category: String;
  user: PiaUser;
  username: String;
  password: String;
  retyped: String;
  gender: number;
  email: String;
  address: String;
  bio: String;



  constructor( private routeInfo: ActivatedRoute,
              private userService: UserService,
              private router: Router) {
    // 响应组件内部导航
  /*  routeInfo.params.subscribe(
      params => {
        this.category = params['category'];
        this.category =  this.category.trim().toUpperCase();
        //  获取用户信息
        this.user =  userService.getCurrentUser();
      }
    );*/
  }




  changePageToSignUp(): void {
    this.category = 'SIGNUP';
  }

  changePageToSignIn(): void {
    this.category = 'SIGNIN';
  }

  submitForm() {
    this.isSubmitting = true;
    this.errors = {errors: {}};
    // todo: 确定authForm对象的结构，看是否可以将现有的塞进去，或者替换！！！！
    const credentials = this.authForm.value;
    this.userService
      .attemptAuth(this.authType, credentials)
      .subscribe(
         data => this.router.navigateByUrl('/'),
        err => {
          this.errors = err;
          this.isSubmitting = false;
        }
      );
  }


}
