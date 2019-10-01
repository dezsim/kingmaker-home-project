import { Component, OnInit, Input } from '@angular/core';
import { KingmakerService } from 'src/app/services/kingmaker.service';
import { Player } from 'src/app/player.model';

@Component({
  selector: 'app-kingmaker',
  templateUrl: './kingmaker.component.html',
  styleUrls: ['./kingmaker.component.css']
})
export class KingmakerComponent implements OnInit {

  @Input()
  private username : string;

  private playerBlue : any = "";

  private playerRed : Player = new Player(10, "pista", 2, 3, 5, 7);

  constructor(private kingmakerService : KingmakerService) { }

  ngOnInit() {
    
  }

  newGame(){

  }

  login(){
    console.log(this.kingmakerService.login("john", "123"));
  }

 send(){
    this.kingmakerService.sendUsername(this.username).subscribe();
    this.kingmakerService.getUser(this.username).subscribe(player => this.playerBlue = player);
  }

  get(){
    this.kingmakerService.getUser(this.username).subscribe(player => this.playerBlue = player);
  }

}
