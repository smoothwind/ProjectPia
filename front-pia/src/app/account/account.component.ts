import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';
import {PiaUser} from '../model/pia-user';
import {environment} from '../../environments/environment';
import {EPiaErrCode} from '../model/enums';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent {
  category: String;
  user: PiaUser;
  // iu: InputedUser = new InputedUser();
  username: String;
  password: String;
  retyped: String;
  gender: number;
  email: String;
  address: String;
  bio: String;



  constructor(private routeInfo: ActivatedRoute, private userService: UserService, private router: Router) {
    // 响应组件内部导航
    routeInfo.params.subscribe(
      params => {
        this.category = params['category'];
        this.category =  this.category.trim().toUpperCase();
        //  获取用户信息
        this.user =  userService.getCurrentUser();
      }
    );
  }
  signUp(): boolean | any {
    this.user = new PiaUser();
    this.user.userName = this.username;
    this.user.password = this.password;
    this.user.address = this.address;
    this.user.bio = this.bio;
    this.user.eMail = this.email;
    this.user.gender = this.gender;

    if( this.userService.signUp(this.user) === EPiaErrCode.SUCCESS){
      this.user = this.userService.getCurrentUser();
      this.router.navigate(['/Account/default']);
    }

    return false;
  }

  signIn(): boolean | any {
     if (this.userService.logIn(this.username, this.password) === EPiaErrCode.SUCCESS) {
       this.user = this.userService.getCurrentUser();

       if (this.user === null) {
         console.log('user is null');
       }

       if (!environment.production) {
        // let message: String;
        // message = this.user.toString();
         console.log(this.username + ' is logged!');
       }
       // TODO: 登录成功 返回到上一页 或者 首页 并更改导航栏外观！
       this.router.navigate(['/Account/default']);
        //return true;
     }
    if (!environment.production) {
      console.log(this.username + ' is logged fail!');
    }
    return false;
  }


  changePageToSignUp(): void {
    this.category = 'SIGNUP';
  }

  changePageToSignIn(): void {
    this.category = 'SIGNIN';
  }


/*
  ngOnInit() {
    // 获取当前路由
    this.category = this.routeInfo.snapshot.params['category'];
    this.category =  this.category.trim().toUpperCase();
  }*/

}
