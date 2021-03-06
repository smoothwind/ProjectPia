import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import { slideInAnimation } from './animations';
import {NavigationEnd, Router, RouterOutlet} from '@angular/router';
import {UserService} from './core/services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [ slideInAnimation ]
 })
// export class AppComponent implements OnInit {
//   user: PiaUser;
//   constructor( private userService: UserService) { }
//
//   getUserInfo() {
//       console.log('AppComponent. getUserInfo');
//       this.userService.getUserByID(1).subscribe((data: PiaUser) => this.user = data);
//
//     }
//
//
//
//   ngOnInit() {
//     console.log('AppComponent. ngOnInit');
//     this.getUserInfo();
//   }
// }
export class AppComponent implements OnInit, OnChanges {
  title = 'Pia';


  constructor(private userService: UserService,
              private router: Router) {
    router.events.subscribe(e => {
      // console.log(e);
      if (e instanceof NavigationEnd) {
        //this.user = (this.userService.getCurrentUser());
        //console.log('NavigationEnd 获取到：' + (this.user == null ? 'nothing' : this.user.userName));
      } else {
        //this.user = this.userService.getCurrentUser();
        //console.log('其他事件 获取到：' +  (this.user == null ? 'nothing' : this.user.userName));
      }
    });
  }


  getAnimationData(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData && outlet.activatedRouteData['animation'];
  }


  ngOnInit(): void {
    //this.user = this.userService.getCurrentUser();
  }

  ngOnChanges(changes: SimpleChanges): void {
    //this.user = this.userService.getCurrentUser();
    console.log('AppComponent: Change Detected!');
  }

  // TODO: 根据UserService更改IsLogin
  isLogin() {}


}
