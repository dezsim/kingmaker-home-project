import { Component, OnInit, EventEmitter } from '@angular/core';
import { KingmakerService } from 'src/app/services/kingmaker.service';
import { AuthService } from 'src/app/services/auth.service';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';



@Component({
  selector: 'app-kingmaker',
  templateUrl: './kingmaker.component.html',
  styleUrls: ['./kingmaker.component.css']
})


export class KingmakerComponent implements OnInit {

  public onChangeSelectOption : EventEmitter<number> = new EventEmitter<number>();
  model : any = "";
  public quests = [
    {id: 1, name: "CON"},
    {id: 2, name: "AMBUSH"},
    {id: 3, name: "ASSASINATE"},
    {id: 4, name: "ROB"},
    {id: 5, name: "SUE"},
    {id: 6, name: "DEFEND"},
    {id: 7, name: "BRIBE"},
    {id: 8, name: "SPREAD RUMORS"},
    {id: 9, name: "HOST PARTY"},
    {id: 10, name: "PRAISE"},
    {id: 11, name: "HEAL"},
    {id: 12, name: "MAKE MONEY"},
    {id: 13, name: "SPY"}
  ];

  public selectedValue = null;

  constructor(private kingmakerService : KingmakerService, private auth : AuthService) { }

  ngOnInit() {
    this.kingmakerService.getPlayerData().subscribe(m => this.model = m);

  }

  public connectServer() {
    this.kingmakerService.connectServer();
  }

  public joinGame(){
    this.kingmakerService.joinGame();
  }

  public build(){
    this.kingmakerService.build("GOLDMINE");
  }

  public hire(){
    this.kingmakerService.hire("DIPLOMAT");
  }

  public startQuest(){
    console.log(this.selectedValue);
  }

  public onChange(){
    this.onChangeSelectOption.emit(this.selectedValue);
    console.log(this.selectedValue);
  }
}
