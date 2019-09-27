import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KingmakerComponent } from './components/kingmaker/kingmaker.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { KingmakerService } from './services/kingmaker.service';
import { RulesComponent } from './rules/rules.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    KingmakerComponent,
    HeaderComponent,
    RulesComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [KingmakerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
