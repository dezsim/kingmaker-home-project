import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KingmakerComponent } from './components/kingmaker/kingmaker.component';
import { RulesComponent } from './components/rules/rules.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';


const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "kingmaker", component: KingmakerComponent},
  {path: "rules", component: RulesComponent},
  {path: "login", component: LoginComponent},
  {path: "registration", component: RegistrationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
