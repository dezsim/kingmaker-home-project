import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KingmakerComponent } from './components/kingmaker/kingmaker.component';
import { RulesComponent } from './rules/rules.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "kingmaker", component: KingmakerComponent},
  {path: "rules", component: RulesComponent},
  {path: "login", component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
