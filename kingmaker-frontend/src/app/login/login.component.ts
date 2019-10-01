import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticateService } from '../authenticate.service';

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  credentials = {username: '', password: ''};

  constructor(private auth : AuthenticateService, private http: HttpClient, private router: Router) {
  }

  login() {
    this.auth.authenticate(this.credentials, () => {
        this.router.navigateByUrl('/');
    });
    return false;
  }

}