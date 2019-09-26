import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KingmakerComponent } from './components/kingmaker/kingmaker.component';


const routes: Routes = [
  {path: "kingmaker", component: KingmakerComponent},
  {path: "", component: KingmakerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
