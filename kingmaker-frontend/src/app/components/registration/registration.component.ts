import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerForm: FormGroup;
  username = '';
  password = '';
  isLoadingResults = false;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username : [null, Validators.required],
      password : [null, Validators.required],
        },);
  
  }

  onFormSubmit(form: NgForm) {
    console.log(this.registerForm)
    this.authService.register(form)
      .subscribe(res => {
        this.router.navigate(['login']);
      }, (err) => {
        console.log(err);
        alert(err.error);
      });
  }
}


  

  
