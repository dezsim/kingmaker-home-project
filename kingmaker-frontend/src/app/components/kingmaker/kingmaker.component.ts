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

  public buildings =[
    {id: 1, name: "GOLDMINE"},
    {id: 2, name: "BANK"},
    {id: 3, name: "VINEYARD"},
    {id: 4, name: "MARKETPLACE"}
  
  ]

  public crew =[
    {id: 1, name: "DIPLOMAT"},
    {id: 2, name: "THIEF"},
    {id: 3, name: "WARRIOR"}
  ]

  public onChangeSelectOption : EventEmitter<number> = new EventEmitter<number>();
  playerModel : any = "";
  buildingModel : any = "";
  crewModel : any = "";
  opponent : string = "";
  oppBuilding : any = "";
  oppCrew : any = "";
  enemyPlayer : any = "";
  myTurn : boolean;
  gameOver : boolean;


  interval : any;
  mainRefresh : any;
  
  public selectedValue = null;

  constructor(private kingmakerService : KingmakerService, private auth : AuthService) { }

  ngOnInit() {
    this.kingmakerService.getPlayerData().subscribe(m => {
       this.playerModel = m;
    });
    

    this.mainRefresh = setInterval(() => {
      this.kingmakerService.getOppBuildings().subscribe(ob => {
        this.oppBuilding = ob;
      });
      this.kingmakerService.getBuildings().subscribe(b => {
        this.buildingModel = b;
      });
      this.kingmakerService.getCrew().subscribe(c => {
        this.crewModel = c;
      });
      this.kingmakerService.getOppCrew().subscribe(c => {
        this.oppCrew = c;
      });
      this.kingmakerService.getPlayerData().subscribe(p => {
        this.playerModel = p;
      })
      this.kingmakerService.getOppData().subscribe(p => {
        this.enemyPlayer = p;
      })
      this.myTurn = this.kingmakerService.myTurn;
      console.log(this.myTurn);
    }, 2000)
    

    this.interval = setInterval(() => {
      if(localStorage.getItem('enemy') != null){
        clearInterval(this.interval);
        this.opponent = localStorage.getItem('enemy');
      }
      this.getGameData();
    }, 1000);
   
  }

  public getGameData(){
    this.kingmakerService.getGame();
  }

  public connectServer() {
    this.kingmakerService.connectServer();
  }

  public joinGame(){
    this.kingmakerService.joinGame();
  }

  public build(){
    this.kingmakerService.build(this.selectedValue.name);
  }

  public hire(){
    this.kingmakerService.hire(this.selectedValue.name);
  }

  public startQuest(){
    console.log(this.selectedValue);
  }

  public onChange(){
    this.onChangeSelectOption.emit(this.selectedValue.name);
    console.log(this.selectedValue);
  }

  public endTurn(){
    this.kingmakerService.endTurn();
  }
}
