import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  activeRoute: string;
  constructor(private router: Router, private auth : AuthService) {}


  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.activeRoute = event.url;
      }
    });
  }

  isAuthenticated() : boolean{
    return this.auth.isAuthenticated();
  }

  logout(){
    localStorage.clear();
    this.auth.setLoginStatus();
    this.router.navigateByUrl('');
  }

}
