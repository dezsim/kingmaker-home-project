import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KingmakerComponent } from './components/kingmaker/kingmaker.component';
import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { KingmakerService } from './services/kingmaker.service';
import { RulesComponent } from './rules/rules.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthenticateService } from './authenticate.service';

@NgModule({
  declarations: [
    AppComponent,
    KingmakerComponent,
    HeaderComponent,
    RulesComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [KingmakerService, AuthenticateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
