import { Component, Input } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  @Input()
  username : string;

  @Input()
  password : string;

  constructor(private auth : AuthService) {
  }

  login() {
    this.auth.login(this.username, this.password);
  }

}