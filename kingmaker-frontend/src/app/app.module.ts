import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';


import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './token.interceptor';


import { KingmakerService } from './services/kingmaker.service';
import { AuthService } from './services/auth.service';


import { AppComponent } from './app.component';
import { KingmakerComponent } from './components/kingmaker/kingmaker.component';
import { HeaderComponent } from './components/header/header.component';
import { RulesComponent } from './components/rules/rules.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';



@NgModule({
  declarations: [
    AppComponent,
    KingmakerComponent,
    HeaderComponent,
    RulesComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [KingmakerService, AuthService ,  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
