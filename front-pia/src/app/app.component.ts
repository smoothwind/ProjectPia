import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
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
  constructor() { }
}
