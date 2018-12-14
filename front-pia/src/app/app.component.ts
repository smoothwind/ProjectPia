import { Component } from '@angular/core';
import { slideInAnimation } from './animations';
import { RouterOutlet } from '@angular/router';
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
export class AppComponent {
  title = 'hello,world';
  username = 'tester';
  constructor() { }

  getAnimationData(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData && outlet.activatedRouteData['animation'];
  }
  isLogin(): boolean{
    return false;
  }

}
